package com.xinyuan.circle.entity.mysql;

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
@Table(name = "c_circle")
public class Circle implements Serializable {

    @Id
    @ApiModelProperty(value = "主键", name = "id", example = "0")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ApiModelProperty(value = "名称", name = "name", example = "name")
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "图片", name = "image", example = "url")
    @Column(name = "image")
    private String image;

    @ApiModelProperty(value = "排序", name = "position", example = "1")
    @Column(name = "position")
    private Integer position;

    @ApiModelProperty(value = "删除标识 0未删除 1已删除", name = "deleted", example = "0")
    @Column(name = "deleted")
    private Integer deleted = 0;
}
