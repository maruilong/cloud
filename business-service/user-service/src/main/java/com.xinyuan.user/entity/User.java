package com.xinyuan.user.entity;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(value = "主键", name = "id", example = "0")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ApiModelProperty(value = "用户名（唯一）", name = "username", example = "username")
    @Column(name = "username", unique = true)
    private String username;

    @ApiModelProperty(value = "密码", name = "password", example = "password")
    @Column(name = "password")
    private String password;

    @ApiModelProperty(value = "状态(0,1)，0停用，1启用", name = "status", example = "0")
    @Column(name = "status")
    private Integer status;

    @ApiModelProperty(value = "真实姓名", name = "realName", example = "张三")
    @Column(name = "real_name")
    private String realName;

    @ApiModelProperty(value = "电话号码", name = "phone", example = "15666666666")
    @Column(name = "phone")
    private String phone;

    @ApiModelProperty(value = "微信openId", name = "openId", example = "wxAAAAAA123456789")
    @Column(name = "open_id")
    private String openId;

    @ApiModelProperty(value = "密码是否已修改1：是，0：否", name = "modified", example = "1")
    @Column(name = "modified")
    private Integer modified;

    @ApiModelProperty(value = "所属单位id", name = "unitId", example = "1")
    @Column(name = "unit_id")
    private Long unitId;

    @ApiModelProperty(value = "人员id", name = "userId", example = "1")
    @Column(name = "ry_id")
    private Long userId;

    @ApiModelProperty(value = "头像", name = "photo", example = "1")
    @Column(name = "photo")
    private String photo;

    @ApiModelProperty(value = "删除标识 0未删除 1已删除", name = "deleted", example = "0")
    @Column(name = "deleted")
    private Integer deleted = 0;
}
