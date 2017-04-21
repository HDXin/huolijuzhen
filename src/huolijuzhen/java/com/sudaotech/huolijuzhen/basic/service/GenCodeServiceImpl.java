package com.sudaotech.huolijuzhen.basic.service;

import com.google.inject.Inject;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.util.DateUtils;
import com.sudaotech.huolijuzhen.basic.dao.GenCodeMapper;

import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("Duplicates")
public class GenCodeServiceImpl extends BaseServiceImpl implements GenCodeService {
    private static final String TRACKING_TYPE = "GenCode";

    @Inject
    private GenCodeMapper genCodeMapper;

    @Override
    public String nextCodeByType(String type) {
        GenCode genCode = new GenCode();
        genCode.setCodeType(type);
        Long maxCode = genCodeMapper.selectMaxCode(type);
        if (maxCode == null) {
            genCode.setCode(1L);
        } else {
            maxCode++;
            genCode.setCode(maxCode);
        }
        genCodeMapper.insertSelective(genCode);
        return type + getGenCode(genCode.getCode());
    }

    @Override
    public String nextCodeByTypeAndTime(String type, Date startTime, Date endTime) {
        GenCode genCode = new GenCode();
        genCode.setCodeType(type);
        Long maxCode = genCodeMapper.selectMaxCodeByTime(type, DateUtils.getDateBegin(new Date()), DateUtils.getDateEnd(new Date()));
        if (maxCode == null) {
            genCode.setCode(1L);
        } else {
            maxCode++;
            genCode.setCode(maxCode);
        }
        genCodeMapper.insertSelective(genCode);
        return type + getGenCodeByTime(genCode.getCode());
    }

    private String getGenCodeByTime(Long code) {
        StringBuilder codeStr = new StringBuilder();
        String time = new SimpleDateFormat("yyyyMMdd").format(new Date());
        codeStr.append(time);
        if (code > 0 && code < 10) {
            codeStr.append("00000").append(code);
        } else if (code >= 10 && code < 100) {
            codeStr.append("0000").append(code);
        } else if (code >= 100 && code < 1000) {
            codeStr.append("000").append(code);
        } else if (code >= 1000 && code < 10000) {
            codeStr.append("00").append(code);
        } else if (code >= 10000 && code < 100000) {
            codeStr.append("0").append(code);
        } else {
            codeStr.append(code);
        }
        return codeStr.toString();
    }


    private String getGenCode(Long code) {
        StringBuilder codeStr = new StringBuilder();
        if (code > 0 && code < 10) {
            codeStr.append("00000").append(code);
        } else if (code >= 10 && code < 100) {
            codeStr.append("0000").append(code);
        } else if (code >= 100 && code < 1000) {
            codeStr.append("000").append(code);
        } else if (code >= 1000 && code < 10000) {
            codeStr.append("00").append(code);
        } else if (code >= 10000 && code < 100000) {
            codeStr.append("0").append(code);
        } else {
            codeStr.append(code);
        }
        return codeStr.toString();
    }
}
