package com.xinyuan.circle.mapper;

import com.xinyuan.circle.entity.Topic;
import org.springframework.stereotype.Repository;

/**
 * @author liang

 */
@Repository
public interface TopicRepository extends BaseJpaRepository<Topic,Long> {

    Topic findByIdAndDeleted(Long id, int deleted);
}
