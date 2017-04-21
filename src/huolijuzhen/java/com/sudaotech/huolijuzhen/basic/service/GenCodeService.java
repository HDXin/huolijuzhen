package com.sudaotech.huolijuzhen.basic.service;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.dao.GenCodeEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

public interface GenCodeService extends BaseService {


    /**
     * 根据传入的前缀,生成code
     *
     * @param type 前缀
     * @return 生成的流水code
     * @Demo
     * @Test public void gencode() {
     * for (int index = 1; index <= 10; index++) {
     * String a = genCodeService.nextCodeByType(GenCodeService.LocalContains.PARK);
     * logger.info(a);
     * }
     * for (int index = 1; index <= 10; index++) {
     * String a = genCodeService.nextCodeByTypeAndTime(GenCodeService.LocalContains.SP01, new Date(), new Date());
     * logger.info(a);
     * }
     * }
     */
    public String nextCodeByType(String type);

    /**
     * 根据传入的前缀和开始日期,生成code
     *
     * @param type 前缀
     * @return 生成的流水code
     * @Demo
     * @Test public void gencode() {
     * for (int index = 1; index <= 10; index++) {
     * String a = genCodeService.nextCodeByTypeAndTime(GenCodeService.LocalContains.SP01, new Date(), new Date());
     * logger.info(a);
     * }
     * }
     */
    public String nextCodeByTypeAndTime(String type, Date startTime, Date endTime);


    interface LocalContains {
        //默认的前缀
        String PARK = "P（Park）+区号";
        String SP02 = "SP02";
        String SP01 = "SP01";
        String E="E";
    }


    public static class Query extends Pagination {
    }

    public static class GenCode extends GenCodeEntity {

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }
    }
}
