package com.sudaotech.core.config;

import java.util.List;

public class BlackWordsConfig {
    private static final BlackWordsConfig instance = ConfigLoader.loadYamlAs("black-words.yaml", BlackWordsConfig.class);
    
    private List<String> blackWords;
    
    public List<String> getBlackWords() {
        return blackWords;
    }

    public void setBlackWords(List<String> blackWords) {
        this.blackWords = blackWords;
    }

    public static BlackWordsConfig getInstance() {
        return instance;
    }
}
