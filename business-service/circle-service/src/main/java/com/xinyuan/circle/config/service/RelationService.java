package com.xinyuan.circle.config.service;

import com.xinyuan.relation.client.RelationClient;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author shinian
 */
//@FeignClient(value = "relation-service", fallback = RelationHystric.class)
@FeignClient(value = "relation-service")
public interface RelationService extends RelationClient {
}
