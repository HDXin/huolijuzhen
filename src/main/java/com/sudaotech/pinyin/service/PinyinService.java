package com.sudaotech.pinyin.service;

import java.util.List;

import com.sudaotech.core.service.BaseService;

public interface PinyinService extends BaseService {
	
    List<String> getWordsByPinyin(String pinyin);

    List<String> getPinyinByWords(String words);

    List<String> getAbbrevPinyinByWords(String words);
    
    List<String> getMixedPinyinByWords(String words);
}
