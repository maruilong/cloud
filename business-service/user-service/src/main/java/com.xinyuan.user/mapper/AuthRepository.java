package com.xinyuan.user.mapper;

import com.xinyuan.base.mapper.BaseJpaRepository;
import com.xinyuan.user.entity.Auth;
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
