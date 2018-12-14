package com.xinyuan.relation.client;

import com.xinyuan.relation.client.hystric.RelationHystric;
import com.xinyuan.relation.model.dto.RelationDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 * @author liang
 */
@FeignClient(value = "relation-service", fallback = RelationHystric.class)
public interface RelationClient {

    @RequestMapping(value = "/api/relation/add", method = RequestMethod.POST)
    ResponseEntity<RelationDTO> add(@RequestBody RelationDTO relationDTO);
}
