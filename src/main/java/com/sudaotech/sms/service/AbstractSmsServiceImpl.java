package com.sudaotech.sms.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.ibatis.session.RowBounds;

import com.github.pagehelper.PageHelper;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.sudaotech.core.Session;
import com.sudaotech.core.dao.entity.EntityHelper;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.sms.SmsConfig;
import com.sudaotech.sms.SmsConfig.LimitControl;
import com.sudaotech.sms.SmsStatus;
import com.sudaotech.sms.dao.SmsHistoryEntity;
import com.sudaotech.sms.dao.SmsHistoryEntityExample;
import com.sudaotech.sms.dao.SmsHistoryEntityMapper;
import com.sudaotech.util.BeanUtils;

public abstract class AbstractSmsServiceImpl extends BaseServiceImpl implements SmsService {
    
    /**
     * 是否开启短信发送服务
     */
    private boolean enabled = false;
    
    @Inject
    private SmsHistoryEntityMapper smsHistoryEntityMapper;
    
    @Inject
    public void setEnabled(@Named("sms.enabled") boolean enabled) {
        this.enabled = enabled;
        this.logger.info("sms.enabled={}", this.enabled);
    }
    
    @Override
    public synchronized final boolean sendSms(Sms sms, Session session) {
        this.logger.info("Sending sms: {}", sms);
        
        //是否短信发生频繁
        if (this.exceedSmsLimit(sms.getPhoneNum(), session)) {
        	this.logger.info("SMS exceed limit, aborted.");
            return false;
        }
        
        // 记录短信发送信息
        sms.setSmsStatus(SmsStatus.PENDING);
        Long smsId = this.createSmsHistory(sms, session);
        // 检查短信服务是否开启
        if (!this.enabled) {
            this.logger.info("SMS Service disabled; pending message, smsId:{}", smsId);
            return false;
        }
        // 执行发送
        boolean isSuccess = this.doSendSms(sms, session);
        // 更新短信发送状态
        this.updateSmsStatus(smsId, isSuccess ? SmsStatus.SUCESSED : SmsStatus.FAILED);
        
        this.logger.info("Sending sms result:  {}", isSuccess);
        return isSuccess;
    }
    
    abstract protected boolean doSendSms(Sms shortMessage, Session session);
    
    /**
     * 是否超出短信限制
     * 24小时内只发送5条信息
     * 60s内只发送一次
     * @param shortMessage
     * @return
     */
    private boolean exceedSmsLimit(String phoneNum, Session session) {
        List<LimitControl> limitControls = SmsConfig.getInstance().getLimitControls();
        // 没有限制
        if (CollectionUtils.isEmpty(limitControls)) {
            return false;
        }
        
        // 获取最大限制
        int n = 0;
        for (LimitControl limitControl : limitControls) {
            // 限制为0条，直接返回，认为超出限制
            if (limitControl.getLimit() == 0) {
                return true;
            }
            
            if (limitControl.getLimit() > n) {
                n = limitControl.getLimit();
            }
        }

        // 获取最近N条短信
        List<SmsHistoryEntity> smsHistory = this.getLatestSmsHistory(phoneNum, n);

        // 若没有短信发送记录，无需继续验证
        if (smsHistory.isEmpty()) {
            return false;
        }
        
        // 规则验证
        final int size = smsHistory.size();
        for (LimitControl limitControl : limitControls) {
            final int index = limitControl.getLimit() < size ? limitControl.getLimit() : size;
            final SmsHistoryEntity sms = smsHistory.get(index - 1);
            long gap = System.currentTimeMillis() - sms.getCreateTime().getTime();
            if (gap < limitControl.getInterval() * 1000
                    && limitControl.getLimit() == index) {
                this.logger.warn("phone({}) offend limit control: {}", phoneNum, limitControl);
                return true;
            }
        }

    	return false;
    }
    
    
    private void updateSmsStatus(Long smsId, SmsStatus smsStatus) {
        SmsHistoryEntity entity = new SmsHistoryEntity();
        entity.setSmsId(smsId);
        entity.setSmsStatus(smsStatus);
        entity.setUpdateTime(new Date());
        
        this.smsHistoryEntityMapper.updateByPrimaryKeySelective(entity);
    }
    
	private Long createSmsHistory(Sms sms, Session session) {
    	sms.setSmsId(this.getSequenceService().nextLong());
		
    	SmsHistoryEntity entity = BeanUtils.copyProperties(sms, SmsHistoryEntity.class);
    	EntityHelper.setCreateStatusFields(entity, Status.NORMAL, session);
        this.smsHistoryEntityMapper.insertSelective(entity);
        
        return sms.getSmsId();
	}
    
	private List<SmsHistoryEntity> getLatestSmsHistory(String phoneNum, int limit) {
        SmsHistoryEntityExample example = new SmsHistoryEntityExample();
        example.setOrderByClause("smsId DESC");
        example.createCriteria().andPhoneNumEqualTo(phoneNum);
        
        PageHelper.startPage(1, limit, false);
        return this.smsHistoryEntityMapper.selectByExampleWithRowbounds(example, new RowBounds(0, limit));
	}
}
