package com.xinyuan.upload.entity;

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
@Table(name = "p_file")
public class FileInfor implements Serializable {

    @Id
    @ApiModelProperty(value = "主键", name = "id", example = "0")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ApiModelProperty(value = "文件路径", name = "filePath", example = "/APP/app/www/upload/")
    @Column(name = "file_path")
    private String filePath;

    @ApiModelProperty(value = "文件名称", name = "fileName", example = "test.doc")
    @Column(name = "file_name")
    private String fileName;

    @ApiModelProperty(value = "删除标识 0未删除 1已删除", name = "deleted", example = "0")
    @Column(name = "deleted")
    private Integer deleted;

}
