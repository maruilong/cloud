package com.xinyuan.circle.entity.mysql;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author hwz
 */
@Data
@Entity
@Table(name = "sys_user_role")
public class UserRole implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "u_id")
    private Long uid;

    @Column(name = "r_id")
    private Long rid;

    @Column(name = "deleted")
    private Integer deleted = 0;
}
