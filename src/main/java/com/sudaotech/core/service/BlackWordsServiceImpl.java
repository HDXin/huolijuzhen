package com.sudaotech.core.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.sudaotech.core.config.BlackWordsConfig;

public class BlackWordsServiceImpl extends BaseServiceImpl implements BlackWordsService {

    private final BlackWordsConfig blackWordsConfig;
    private final Set<String> blackWords = new HashSet<String>();
    private final List<Pattern> blackWordsPattern = new ArrayList<Pattern>();

    public BlackWordsServiceImpl() {
        blackWordsConfig = BlackWordsConfig.getInstance();
        for (String item : blackWordsConfig.getBlackWords()) {
            String str = StringUtils.trim(item);
            if (StringUtils.isBlank(str)) {
                continue; // skip blank item
            }
            blackWords.add(str);
            blackWordsPattern.add(Pattern.compile(str, Pattern.CASE_INSENSITIVE));
        }
    }
    
    @Override
    public boolean isBlack(String words) {
        String s = StringUtils.trim(words);
        if (StringUtils.isBlank(s)) {
            return false;
        }
        if (blackWords.contains(s)) {
            return true;
        }
        
        for (Pattern p : blackWordsPattern) {
            if (p.matcher(s).find()) {
                return true;
            }
        }
        
        return false;
    }
}
