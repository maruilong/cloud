package com.xinyuan.relation.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @Author: hwz
 * @Date: Created in 16:54 2018/12/10.
 */
@Data
@Entity
@Table(name = "c_relation")
public class Relation implements Serializable {

    @Id
    @ApiModelProperty(value = "主键", name = "id", example = "0")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ApiModelProperty(value = "源id", name = "srcUser", example = "1")
    @Column(name = "src_user")
    private Long srcUser;

    @ApiModelProperty(value = "源类型", name = "srcType", example = "user")
    @Column(name = "src_type")
    private String srcType;

    @ApiModelProperty(value = "动作类型", name = "actionType", example = "answer")
    @Column(name = "action_type")
    private String actionType;

    @ApiModelProperty(value = "目标类型", name = "targetType", example = "topic")
    @Column(name = "target_type")
    private String targetType;

    @ApiModelProperty(value = "目标id", name = "targetId", example = "1")
    @Column(name = "target_id")
    private Long targetId;

    @ApiModelProperty(value = "删除标识 0未删除 1已删除", name = "deleted", example = "0")
    @Column(name = "deleted")
    private Integer deleted = 0;
}
