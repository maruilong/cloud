package com.xinyuan.base.common.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author liang
 */
@Data
@MappedSuperclass
public class BaseEntity {

    @Column(name = "deleted", columnDefinition = "INT default 0")
    private Integer deleted = 0;
}
