package com.uralfoxes.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "site_user")
@Data
public class SystemUser implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_login")
    private String login;

    @Column(name = "user_passwd")
    private byte[] password;

    @Column(name = "enabled")
    private boolean enabled;

    public SystemUser() {

    }

}
