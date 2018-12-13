package com.xinyuan.circle.client;

import com.xinyuan.base.entity.Relation;
import com.xinyuan.circle.client.hystric.RelationHystric11;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author liang
 */
@FeignClient(value = "relation-service", fallback = RelationHystric11.class)
public interface RelationClient1 {

    @RequestMapping(value = "/relation/add", method = RequestMethod.POST)
    ResponseEntity<Relation> add(@RequestBody Relation relation);
}
