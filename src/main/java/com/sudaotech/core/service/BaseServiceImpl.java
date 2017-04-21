package com.sudaotech.core.service;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.sudaotech.cache.service.CacheService;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.redis.service.RedisCacheService;
import com.sudaotech.sequence.service.SequenceService;
import com.sudaotech.tracking.service.TrackingService;

public class BaseServiceImpl implements BaseService{
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Inject
    private CacheService cacheService;

    @Inject
    private RedisCacheService redisCacheService;

    @Inject
    private SequenceService sequenceService;

    @Inject
    protected TrackingService trackingService;

    @Inject
    private SqlSession sqlSession;

    @Override
    public void init() throws Exception {
    }

    @Override
    public void destroy() {
    }

    public CacheService getCacheService() {
        return cacheService;
    }

    public RedisCacheService getRedisCacheService() {
        return redisCacheService;
    }

    public SequenceService getSequenceService() {
        return sequenceService;
    }

    public TrackingService getTrackingService() {
        return trackingService;
    }

    public void setTrackingService(TrackingService trackingService) {
        this.trackingService = trackingService;
    }

    public SqlSession getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setCacheService(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    public void setRedisCacheService(RedisCacheService redisCacheService) {
        this.redisCacheService = redisCacheService;
    }

    public void setSequenceService(SequenceService sequenceService) {
        this.sequenceService = sequenceService;
    }

    protected RowBounds toRowBounds(Pagination pagination) {
        return new RowBounds(pagination.getOffset(), pagination.getLimit());
    }
}
