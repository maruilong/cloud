package com.xinyuan.circle.entity.pgsql;

import io.swagger.annotations.ApiModelProperty;
import static javax.persistence.GenerationType.IDENTITY;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "c_book")
public class Book {

    @Id
    @ApiModelProperty(value = "主键", name = "id", example = "0")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ApiModelProperty(value = "内容", name = "content", example = "内容")
    @Column(name = "content")
    private String content;
}
