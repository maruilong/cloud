package com.xinyuan.circle.service;

import com.xinyuan.relation.client.RelationClient;
import com.xinyuan.circle.service.hystric.RelationHystric;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author shinian
 */
@FeignClient(value = "relation-service", fallback = RelationHystric.class)
public interface RelationService extends RelationClient {
}
