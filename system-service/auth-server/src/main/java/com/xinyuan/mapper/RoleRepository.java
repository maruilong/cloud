package com.xinyuan.mapper;

import com.xinyuan.entity.Role;
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
