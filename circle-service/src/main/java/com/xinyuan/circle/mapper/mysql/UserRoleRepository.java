package com.xinyuan.circle.mapper.mysql;

import com.xinyuan.circle.entity.mysql.UserRole;
import com.xinyuan.base.mapper.BaseJpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liang
 */
@Repository
public interface UserRoleRepository extends BaseJpaRepository<UserRole, Long> {

    /**
     * findByUid
     *
     * @param uid
     * @return
     */
    UserRole findByUid(Long uid);

    @Query(value = "select r.role_name from sys_user_role ur left join sys_role r on ur.r_id=r.id where ur.u_id = ?1", nativeQuery = true)
    List<String> findRoleName(Long uid);


    List<UserRole> findByRidAndDeleted(Long rid, int deleted);

    List<UserRole> findByRidNotAndDeleted(Long rid, int deleted);

    UserRole findByUidAndDeleted(Long uid, int deleted);

}
