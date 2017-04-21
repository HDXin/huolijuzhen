package com.sudaotech.sms;

import java.util.List;

import com.sudaotech.core.config.ConfigLoader;

public class SmsConfig {
    private static SmsConfig instance = ConfigLoader.loadYamlAs("sms.yaml", SmsConfig.class);
    
    private List<LimitControl> limitControls;

    public static SmsConfig getInstance() {
        return instance;
    }
    
    public List<LimitControl> getLimitControls() {
        return limitControls;
    }

    public void setLimitControls(List<LimitControl> limitControls) {
        this.limitControls = limitControls;
    }

    /**
     * LimitControl用于指定在多长时间范围内允许发生的最大数量
     */
    public static class LimitControl {
        /**
         * 限制数量
         */
        private Integer limit;
        /**
         * 时间间隔
         */
        private Integer interval;
        public Integer getLimit() {
            return limit;
        }
        public void setLimit(Integer limit) {
            this.limit = limit;
        }
        public Integer getInterval() {
            return interval;
        }
        public void setInterval(Integer interval) {
            this.interval = interval;
        }
        @Override
        public String toString() {
            return "LimitControl [limit=" + limit + ", interval=" + interval + "]";
        }
    }
}
