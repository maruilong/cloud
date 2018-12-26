package com.xinyuan.circle.config.service;

import com.xinyuan.relation.client.TestClient;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "relation-service")
public interface TestService extends TestClient {
}
