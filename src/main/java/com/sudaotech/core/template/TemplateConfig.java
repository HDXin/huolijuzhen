package com.sudaotech.core.template;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.sudaotech.core.config.ConfigLoader;


public class TemplateConfig {
    private static final TemplateConfig instance = ConfigLoader.loadYamlAs("template.yaml", TemplateConfig.class);

    private Map<String, String> templates;
    
    public Map<String, String> getTemplates() {
        return templates;
    }

    public void setTemplates(Map<String, String> templates) {
        this.templates = templates;
    }
    
    public static TemplateConfig getInstance(String yaml) {
        return ConfigLoader.loadYamlAs(yaml, TemplateConfig.class);
    }
    
    public static TemplateConfig getInstance() {
        return instance;
    }
    
    /**
     * 使用默认的模板文件(template.yaml)格式化
     * @param tplKey 配置项key
     * @param objects 参数
     * @return 格式化后的结果
     */
    public static String format(String tplKey, Object... objects) {
        if (StringUtils.isBlank(tplKey)) {
            throw new IllegalArgumentException("tplKey missing");
        }
        
        String property = instance.getTemplates().get(tplKey);
        if (property == null) {
            return null;
        }
        return String.format(property, objects);
    }

}
