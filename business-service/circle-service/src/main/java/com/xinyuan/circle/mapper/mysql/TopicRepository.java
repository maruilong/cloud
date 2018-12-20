package com.xinyuan.circle.mapper.mysql;

import com.xinyuan.circle.entity.mysql.Topic;
import com.xinyuan.base.mapper.BaseJpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author liang

 */
@Repository
public interface TopicRepository extends BaseJpaRepository<Topic,Long> {

    Topic findByIdAndDeleted(Long id, int deleted);
}
