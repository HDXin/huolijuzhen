package com.sudaotech.suggest.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.MultiMatchQueryBuilder.Type;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;

import com.google.inject.Inject;
import com.sudaotech.core.Session;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.elastic.service.ElasticSearchService;

public class SuggestServiceImpl extends BaseServiceImpl implements SuggestService {
    private static final String TYPE_SUGGEST = "suggest";
    private static final String INDEX_CONTENT = "content";
    
    private ElasticSearchService elasticSearch;
    
    @Inject
    public SuggestServiceImpl(ElasticSearchService obj) {
        this.elasticSearch = obj;
    }
    
    @Override
    public List<String> getSuggest(String input, Session session) {
        if (StringUtils.isBlank(input)) {
            return Collections.emptyList();
        }
        QueryBuilder queryBuilder = QueryBuilders.multiMatchQuery(input, "name","pinyin").type(Type.PHRASE_PREFIX);
        SearchResponse searchResponse = elasticSearch.getClient().prepareSearch(INDEX_CONTENT).setTypes(TYPE_SUGGEST).setQuery(queryBuilder)
                .setFrom(0)
                .setSize(30)
                .execute()
                .actionGet();
        
        SearchHit[] searchHits = searchResponse.getHits().getHits();
        List<String> result = new ArrayList<String>();
        for (SearchHit hit : searchHits) {
            Object object = hit.getSource().get("name");
            if (object != null) {
                result.add(object.toString());
            }
        }
        
        return result;
    }

    @Override
    public void createSuggest(String name, List<String> pinyin, Session session) throws IOException {
        Map<String, Object> source = new HashMap<String, Object>();
        source.put("name", name);
        source.put("pinyin", pinyin);
        
        IndexResponse indexResponse = elasticSearch.getClient().prepareIndex(INDEX_CONTENT, TYPE_SUGGEST, name)
            .setSource(source)
            .execute()
            .actionGet();
        
        this.logger.debug("prepareIndex: content/suggest/{}, pinyin:{}, indexResponse: id={}, version={}", name, pinyin, indexResponse.getId(), indexResponse.getVersion());
    }
    
}
