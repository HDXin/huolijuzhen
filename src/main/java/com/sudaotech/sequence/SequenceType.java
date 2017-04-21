package com.sudaotech.sequence;

import org.apache.commons.lang3.StringUtils;

public enum SequenceType {
    DEFAULT("sequence"),
    //资源
    SEQUENCE_RESOURCE("sequence_resource"),
    
    /********园区管理********/
    //园区
    SEQUENCE_PARK("sequence_park"),
    //园区组    
    SEQUENCE_PARK_GROUP("sequence_park_group"),

    //用户
    SEQUENCE_USER("sequence_user"),
    //企业
    SEQUENCE_ENTERPRISE("sequence_enterprise"),
    //合同
    SEQUENCT_CONTRACT("sequence_contract"),
    
    //图片资源
    SEQUENCE_BANNER("sequence_banner"),
    
    //费用项目
    SEQUENCE_COST_PRO("sequence_cost_pro"),
    //账单记录
    SEQUENCE_BILL("sequence_bill"),
    //费用项目用量表
    SEQUENCE_COST_PRO_SETTING("sequence_cost_pro_setting"),
    //系统图片
    SEQUENCE_SYS_IMAGE("sequence_sys_image"),
    
    //交易记录
    SEQUENCE_TRANSACTION("sequence_transaction"),
    
    //消息记录
    SEQUENCE_MESSAGE("sequence_message"),
    
    SEQUENCE_BILL_CCR_ADJ("sequence_bill_ccr_adj");
    
    private final String table;

    private SequenceType(String table) {
        if (StringUtils.isBlank(table)) {
            throw new IllegalArgumentException("Empty table name");
        }
        this.table = table;
    }

    public String getTable() {
        return table;
    }
}
