package com.xinyuan.relation.client.hystric;

import com.xinyuan.relation.client.RelationClient;
import com.xinyuan.relation.model.dto.RelationDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 断路器 当原来任务失败的时候执行
 *
 * @author liang
 */
@Slf4j
@Component
public class RelationHystric implements RelationClient {
    @Override
    public ResponseEntity<RelationDTO> add(@RequestBody RelationDTO relationDTO) {

        log.error("relation 保存出错 " + relationDTO);
        return ResponseEntity.ok(relationDTO);
    }
}
