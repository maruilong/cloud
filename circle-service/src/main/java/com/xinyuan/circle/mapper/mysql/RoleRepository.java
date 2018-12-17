package com.xinyuan.circle.mapper.mysql;

import com.xinyuan.circle.entity.mysql.Role;
import com.xinyuan.base.mapper.BaseJpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author liang
 */
@Repository
public interface RoleRepository extends BaseJpaRepository<Role, Long> {

    /**
     * findById
     * @param id
     * @param deleted
     * @return
     */
    Role findByIdAndDeleted(Long id, int deleted);

    /**
     * findByRoleNameAndDeleted
     * @param roleName
     * @param deleted
     * @return
     */
    Role findByRoleNameAndDeleted(String roleName, int deleted);

}
