package com.sudaotech.core.service;


public interface BlackWordsService extends BaseService {
    /**
     * 检查是否是违禁词
     * @param input
     * @return true 
     */
    boolean isBlack(String s);
}
