package com.xinyuan.oauth.entity;

import static javax.persistence.GenerationType.IDENTITY;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

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
