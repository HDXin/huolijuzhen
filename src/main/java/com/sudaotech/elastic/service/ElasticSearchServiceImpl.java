package com.sudaotech.elastic.service;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.sudaotech.core.service.BaseServiceImpl;

public class ElasticSearchServiceImpl extends BaseServiceImpl implements ElasticSearchService {
    private static final Logger logger = LoggerFactory.getLogger(ElasticSearchServiceImpl.class);
    
    private final TransportClient transportClient;

    @Inject
    public ElasticSearchServiceImpl(
            @Named("elasticsearch.cluster.nodes") String nodes,
            @Named("elasticsearch.cluster.name") String clusterName) {
        logger.info("Init cluster.nodes: {}", nodes);
        
        Settings settings = ImmutableSettings.settingsBuilder().put("cluster.name", clusterName).build();
        this.transportClient = new TransportClient(settings);

//        this.transportClient = new TransportClient();

        for (String node : StringUtils.split(nodes, ";")) {
            String[] items = StringUtils.split(node, ":");
            if (ArrayUtils.getLength(items) != 2) {
                throw new IllegalArgumentException("Illegal cluster.nodes: " + nodes);
            }

            transportClient.addTransportAddress(new InetSocketTransportAddress(items[0], Integer.parseInt(items[1])));
        }
    }

    @Override
    public Client getClient() {
        return this.transportClient;
    }

    public void destroy() {
        transportClient.close();
    }

}
