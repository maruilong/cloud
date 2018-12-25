package com.xinyuan.oauth.entity;

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
