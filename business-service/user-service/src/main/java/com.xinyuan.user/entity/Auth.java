package com.xinyuan.user.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author hwz
 */
@Data
@Entity
@Table(name = "t_auth")
public class Auth implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(name = "function_code")
    private String functionCode;

    @Column(name = "jg_id")
    private Integer jgId;

    @Column(name = "ob_id")
    private Integer obId;

    @Column(name = "type")
    private Integer type;

}
