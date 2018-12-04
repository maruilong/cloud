package com.xinyuan.circle.service;

import com.xinyuan.base.config.security.FeignHeaderInterceptor;
import com.xinyuan.relation.client.RelationClient;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author shinian
 */
//@FeignClient(value = "relation-service", fallback = RelationHystric.class)
@FeignClient(value = "relation-service", configuration = FeignHeaderInterceptor.class)
public interface RelationService extends RelationClient {
}
