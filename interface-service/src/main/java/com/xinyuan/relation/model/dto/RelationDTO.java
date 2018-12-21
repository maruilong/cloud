package com.xinyuan.relation.model.dto;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: hwz
 * @Date: Created in 16:54 2018/12/10.
 */
@Data
public class RelationDTO implements Serializable {

    private Long id;

    private Long srcUser;

    private String srcType;

    private String actionType;

    private String targetType;

    private Long targetId;

    private Integer deleted;
}
