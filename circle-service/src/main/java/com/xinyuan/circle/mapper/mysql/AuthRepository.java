package com.xinyuan.circle.mapper.mysql;

import com.xinyuan.circle.entity.mysql.Auth;
import com.xinyuan.base.mapper.BaseJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hwz
 */
@Repository
public interface AuthRepository extends BaseJpaRepository<Auth, Long> {

    /**
     * findByObId
     *
     * @param ObId
     * @return
     */
    List<Auth> findByObId(Integer ObId);

}
