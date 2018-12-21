package com.xinyuan.entity;
import static javax.persistence.GenerationType.IDENTITY;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author hwz
 */
@Data
@Entity
@Table(name = "sys_role")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "role_name",unique = true)
    private String roleName;

    @Column(name = "deleted")
    private Integer deleted = 0;
}
