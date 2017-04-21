package com.sudaotech.suggest.service;

import java.io.IOException;
import java.util.List;

import com.sudaotech.core.Session;
import com.sudaotech.core.service.BaseService;

public interface SuggestService extends BaseService {

    List<String> getSuggest(String input, Session session);
    
    void createSuggest(String name, List<String> pinyin, Session session) throws IOException;
    
}
