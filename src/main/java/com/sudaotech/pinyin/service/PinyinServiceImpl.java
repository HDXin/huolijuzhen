package com.sudaotech.pinyin.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.core.util.Loader;

import com.google.inject.Singleton;
import com.sudaotech.core.service.BaseServiceImpl;

@Singleton
public class PinyinServiceImpl extends BaseServiceImpl implements PinyinService {

    private static final char[] FUZZY_CHARS = new char[]{'z', 'c', 's'};

    private static final String PINYIN_CFG = "pinyin.cfg";

    /**
     * {"中" : "zhong"}
     */
    private final Map<String, List<String>> pinyinMap = new HashMap<String, List<String>>();
    
    /**
     * {"zhong" : "中"}
     */
    private final Map<String, List<String>> wordMap = new HashMap<String, List<String>>();
    
    /**
     * {"z" : "中"}
     */
    private final Map<String, List<String>> abbrevMap = new HashMap<String, List<String>>();

    public PinyinServiceImpl() {
        URL url = Loader.getResource(PINYIN_CFG, this.getClass().getClassLoader());
        logger.info("Loading pinyin.cfg: {}", url.getPath());
        initPinyin(url);
        this.logger.info("Loaded pinyin.cfg: {}", url.getPath());
    }

    private void initPinyin(URL url) {
        InputStream input = null;
        try {
            input = url.openStream();
            List<String> lines = IOUtils.readLines(input);
            for (String line : lines) {
                String[] items = StringUtils.split(line);
                if (ArrayUtils.isEmpty(items) || items.length < 2) {
                    logger.warn("Skip invalid: {}", line);
                    continue;
                }
                
                // pinyinMap
                final String word = items[0];
                final String[] pinyinItems = Arrays.copyOfRange(items, 1, items.length);
                List<String> pinyinList = asList(pinyinItems);
                List<String> list = this.pinyinMap.get(word);
                if (list == null) {
                    this.pinyinMap.put(word, pinyinList);
                } else {
                    list.addAll(pinyinList);
                }
                
                for (String pinyin : pinyinItems) {
                    // wordMap
                    list = this.wordMap.get(pinyin);
                    if (list == null) {
                        this.wordMap.put(pinyin, asList(word));
                    } else {
                        list.add(word);
                    }
                    
                    // abbrevMap
                    String abbrev = pinyin.substring(0, 1);
                    list = this.abbrevMap.get(abbrev);
                    if (list == null) {
                        this.abbrevMap.put(abbrev, asList(word));
                    } else {
                        list.add(word);
                    }
                }
                
            }
        } catch (IOException e) {
            throw new RuntimeException("initPinyin failed", e);
        } finally {
            IOUtils.closeQuietly(input);
        }
    }

    private List<String> asList(String... words) {
        List<String> list = new ArrayList<String>();
        for (String word : words) {
            list.add(word);
        }
        return list;
    }

    @Override
    public List<String> getWordsByPinyin(String pinyin) {
        return wordMap.get(pinyin);
    }

    @Override
    public List<String> getPinyinByWords(String words) {
        return getPinyinByWords(words, false);
    }
    
    /**
     * <pre>
     * 根据汉字获取对应的拼音（全拼，简拼）
     * 1) if abbrev is null，返回全拼和简拼
     * 2) if abbrev is true，返回简拼
     * 3) if abbrev is false，返回全拼
     * </pre>
     * @param words
     * @param abbrev
     * @return
     */
    private List<String> getPinyinByWords(String words, Boolean abbrev) {
        if (StringUtils.isEmpty(words)) {
            return Collections.emptyList();
        }
        
        List<List<String>> matrix = new ArrayList<List<String>>();
        
        for (int i = 0; i < words.length(); i++) {
            String word = words.substring(i, i + 1);
            List<String> pinyinList = this.pinyinMap.get(word);
            if (CollectionUtils.isEmpty(pinyinList)) {
                return Collections.emptyList(); // 没有找到，直接返回空集合
            }
            
            List<String> mixedList = new ArrayList<String>();
            // 简拼
            if (abbrev == null || abbrev) {
                List<String> abbrevList = new ArrayList<String>();
                for (String pinyin : pinyinList) {
                    // 首字母
                    String initials = pinyin.substring(0, 1);
                    abbrevList.add(initials);
                    // 模糊音
                    ArrayUtils.indexOf(FUZZY_CHARS, initials.charAt(0));
                    if (pinyin.length() >= 2 
                            && ArrayUtils.indexOf(FUZZY_CHARS, initials.charAt(0)) >= 0) {
                        if (pinyin.substring(1, 2).equals("h")) {
                            abbrevList.add(pinyin.substring(0, 2));        
                        }
                    }
                }
                mixedList.addAll(abbrevList);
            } 
            
            if (abbrev == null || !abbrev) {
                mixedList.addAll(pinyinList);
            }
            
            matrix.add(mixedList);
        }
        
        // 笛卡尔集
        List<List<String>> cross = cross(matrix);
        List<String> result = new ArrayList<String>();
        for (List<String> list: cross) {
            StringBuilder sb = new StringBuilder();
            for (String item : list) {
                sb.append(item);
            }
            
            result.add(sb.toString());
        }
        
        return result;
    }

    @Override
    public List<String> getAbbrevPinyinByWords(String words) {
        return getPinyinByWords(words, true);
    }

    /**
     * 笛卡尔集
     */
    private List<List<String>> cross(List<List<String>> lists) {
        int n = CollectionUtils.isEmpty(lists) ? 0 : 1;
        for (List<String> list : lists) {
            n *= list.size();
        }

        List<List<String>> result = new ArrayList<List<String>>();        
        for (int i = 0; i < n; i++) {
            int z = i;
            List<String> items = new ArrayList<String>();
            for (int x = 0; x < lists.size(); x++) {
                List<String> list = lists.get(x);
                int index = z % list.size();
                String val = list.get(index);
                items.add(val);
                z = z / list.size();
            }
            
            result.add(items);
        }
                
        return result;
    }

    @Override
    public List<String> getMixedPinyinByWords(String words) {
        return this.getPinyinByWords(words, null);
    }
}
