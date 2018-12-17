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
@Table(name = "t_user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private Integer status;

    @Column(name = "real_name")
    private String realName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "open_id")
    private String openId;

    @Column(name = "modified")
    private Integer modified;

    @Column(name = "unit_id")
    private Long unitId;

    @Column(name = "ry_id")
    private Long userId;

    @Column(name = "deleted")
    private Integer deleted;
}
