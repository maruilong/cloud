package com.xinyuan.circle.config.service;

import com.xinyuan.circle.config.service.hystric.ElasticSearchHystric;
import com.xinyuan.elasticsearch.client.ElasticSearchClient;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "search-service", fallback = ElasticSearchHystric.class)
public interface ElasticSearchService extends ElasticSearchClient {
}
