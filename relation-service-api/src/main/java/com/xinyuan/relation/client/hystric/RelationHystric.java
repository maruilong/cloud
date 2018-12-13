package com.xinyuan.relation.client.hystric;

import com.xinyuan.relation.client.RelationClient;
import com.xinyuan.relation.model.dto.Relation;
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
