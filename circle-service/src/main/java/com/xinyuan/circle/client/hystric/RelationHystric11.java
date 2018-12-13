package com.xinyuan.circle.client.hystric;

import com.xinyuan.base.entity.Relation;
import com.xinyuan.circle.client.RelationClient1;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 断路器 当原来任务失败的时候执行
 *
 * @author liang
 */
@Component
public class RelationHystric11 implements RelationClient1 {
    @Override
    public ResponseEntity<Relation> add(@RequestBody Relation relation) {

        return ResponseEntity.ok(relation);
    }
}
