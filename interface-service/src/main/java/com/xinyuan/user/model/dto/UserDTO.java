package com.xinyuan.user.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hwz
 */
@Data

public class UserDTO implements Serializable {

    private Long id;

    private String username;

    private String password;

    private Integer status;

    private String realName;

    private String phone;

    private String openId;

    private Integer modified;

    private Long unitId;

    private Long userId;

    private String photo;

    private Integer deleted;
}
