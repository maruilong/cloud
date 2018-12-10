package com.xinyuan.circle.hystric;

import com.xinyuan.base.entity.Relation;
import com.xinyuan.circle.client.RelationClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 断路器 当原来任务失败的时候执行
 *
 * @author liang
 */
@Component
public class RelationHystric implements RelationClient {
    @Override
    public ResponseEntity<Relation> add(@RequestBody Relation relation) {

        return ResponseEntity.ok(relation);
    }
}
