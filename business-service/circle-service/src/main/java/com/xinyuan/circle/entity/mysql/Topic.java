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
@Table(name = "c_topic")
public class Topic implements Serializable {

    @Id
    @ApiModelProperty(value = "主键", name = "id", example = "0")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ApiModelProperty(value = "标题", name = "title", example = "标题")
    @Column(name = "title")
    private String title;

    @ApiModelProperty(value = "所属标签", name = "labelId", example = "1")
    @Column(name = "label_id")
    private String labelId;

    @ApiModelProperty(value = "补充说明", name = "supplementary", example = "补充说明")
    @Column(name = "supplementary")
    private String supplementary;

    @ApiModelProperty(value = "图片", name = "images", example = "[{\"/upload/afd5c1ee-409e-43b2-86b4-b239e0e91fd6.jpg\"}]")
    @Column(name = "images")
    private String images;

    @ApiModelProperty(value = "浏览数量", name = "views", example = "0")
    @Column(name = "views")
    private Integer views;

    @ApiModelProperty(value = "回答数量", name = "answers", example = "0")
    @Column(name = "answers")
    private Integer answers;

    @ApiModelProperty(value = "收藏数量", name = "collection", example = "0")
    @Column(name = "collection")
    private Integer collection;

    @ApiModelProperty(value = "用户id", name = "userId", example = "1")
    @Column(name = "user_id")
    private Long userId;

    @ApiModelProperty(value = "发布时间", name = "time", example = "2018-04-12 10:55:23")
    @Column(name = "time",columnDefinition="timestamp")
    private String time;

    @ApiModelProperty(value = "删除标识 0未删除 1已删除", name = "deleted", example = "0")
    @Column(name = "deleted")
    private Integer deleted = 0;
}
