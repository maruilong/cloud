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
@Table(name = "c_comment")
public class Comment implements Serializable {

    @Id
    @ApiModelProperty(value = "主键", name = "id", example = "0")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ApiModelProperty(value = "内容", name = "content", example = "内容")
    @Column(name = "content")
    private String content;

    @ApiModelProperty(value = "图片", name = "images", example = "[{\"/upload/afd5c1ee-409e-43b2-86b4-b239e0e91fd6.jpg\"}]")
    @Column(name = "images")
    private String images;

    @ApiModelProperty(value = "点赞数量", name = "likes", example = "0")
    @Column(name = "likes",columnDefinition = "INT DEFAULT 0")
    private Integer likes;

    @ApiModelProperty(value = "评论数量", name = "comments", example = "0")
    @Column(name = "comments")
    private Integer comments;

    @ApiModelProperty(value = "用户id", name = "userId", example = "1")
    @Column(name = "user_id")
    private Long userId;

    @ApiModelProperty(value = "所属回答", name = "answerId", example = "1")
    @Column(name = "answer_id")
    private Long answerId;

    @ApiModelProperty(value = "父id", name = "pid", example = "1")
    @Column(name = "p_id")
    private Long pid;

    @ApiModelProperty(value = "评论时间", name = "time", example = "2018-04-12 10:55:23")
    @Column(name = "time",columnDefinition="timestamp")
    private String time;

    @ApiModelProperty(value = "删除标识 0未删除 1已删除", name = "deleted", example = "0")
    @Column(name = "deleted")
    private Integer deleted = 0;
}
