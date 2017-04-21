package com.sudaotech.sequence.service;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.sudaotech.core.dao.entity.Sequence;
import com.sudaotech.core.mapper.SequenceMapper;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.sequence.SequenceType;

@Singleton
public class SequenceServiceImpl extends BaseServiceImpl implements SequenceService {
    
    @Inject
    private SequenceMapper sequenceMapper;

    @Override
    public Integer nextInt() {
        return nextInt(SequenceType.DEFAULT);
    }
    @Override
    public Integer nextInt(SequenceType type) {
        return nextLong(type).intValue();
    }

    @Override
    public Long nextLong() {
        return nextLong(SequenceType.DEFAULT);
    }
//    @Override
//    public Long nextLong(Integer type) {
//        if (type == null) {
//            throw new NullPointerException("type is null");
//        }
//        
//        Sequence sequence = new Sequence();
//        sequence.setType(type);
//        this.sequenceMapper.insertWithType(sequence);
//        Long serial = this.sequenceMapper.getSerialBySequenceId(sequence.getSequenceId());
//        
//        return serial;
//    }
    
    @Override
    public Long nextLong(SequenceType type) {
        if (type == null) {
            throw new NullPointerException("sequenceType is null");
        }
        Sequence sequence = new Sequence();
        sequenceMapper.insert(sequence, type.getTable());
        return sequence.getSequenceId();
    }

}