package com.xinyuan.mapper;

import com.xinyuan.entity.Auth;
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
