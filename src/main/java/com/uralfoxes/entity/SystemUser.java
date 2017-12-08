package com.uralfoxes.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "site_user")
@Data
public class SystemUser implements Serializable {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "su_gen", sequenceName = "seq_user", allocationSize = 1)
    @GeneratedValue(generator = "su_gen")
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
