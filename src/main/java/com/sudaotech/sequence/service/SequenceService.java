package com.sudaotech.sequence.service;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.sequence.SequenceType;

public interface SequenceService extends BaseService {

    /**
     * 获取默认sequence
     * @return
     */
    Integer nextInt();
    Long nextLong();
    /**
     * 获取指定类型的sequence
     * @return
     */
    Integer nextInt(SequenceType type);
    Long nextLong(SequenceType type);
}
