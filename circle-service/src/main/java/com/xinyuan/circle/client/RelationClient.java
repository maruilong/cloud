package com.xinyuan.circle.client;

import com.xinyuan.base.entity.Relation;
import com.xinyuan.circle.hystric.RelationHystric;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author liang
 */
@FeignClient(value = "relation-service", fallback = RelationHystric.class)
public interface RelationClient {

    @RequestMapping(value = "/relation/add", method = RequestMethod.POST)
    ResponseEntity<Relation> add(@RequestBody Relation relation);
}
