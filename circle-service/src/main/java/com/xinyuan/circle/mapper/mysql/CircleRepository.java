package com.xinyuan.circle.mapper.mysql;

import com.xinyuan.circle.entity.mysql.Circle;
import com.xinyuan.base.mapper.BaseJpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author liang

 */
@Repository
public interface CircleRepository extends BaseJpaRepository<Circle,Long> {

    Circle findByIdAndDeleted(Long id, int deleted);
}
