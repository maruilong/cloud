package com.xinyuan.circle.mapper;

import com.xinyuan.circle.entity.Circle;
import com.xinyuan.base.mapper.BaseJpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author liang

 */
@Repository
public interface CircleRepository extends BaseJpaRepository<Circle,Long> {

    Circle findByIdAndDeleted(Long id, int deleted);
}
