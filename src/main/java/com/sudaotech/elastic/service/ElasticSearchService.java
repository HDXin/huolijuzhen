package com.sudaotech.elastic.service;

import org.elasticsearch.client.Client;

import com.sudaotech.core.service.BaseService;

public interface ElasticSearchService extends BaseService {

    public abstract Client getClient();

}