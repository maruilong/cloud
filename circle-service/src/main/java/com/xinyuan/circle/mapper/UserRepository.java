package com.xinyuan.circle.mapper;

import com.xinyuan.circle.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author liang
 */
@Repository
public interface UserRepository extends BaseJpaRepository<User, Long> {

    /**
     * 通过username查询
     *
     * @param name
     * @return
     */
    User findByUsername(String name);

    /**
     * findById
     *
     * @param id
     * @return
     */
    User findByIdAndDeleted(Long id, int deleted);

    /**
     * 根据userId查询
     *
     * @param userId
     * @param deleted
     * @return
     */
    User findByUserIdAndDeleted(Long userId, Integer deleted);

}
