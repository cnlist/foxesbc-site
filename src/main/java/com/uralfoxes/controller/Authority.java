package com.uralfoxes.controller;

import com.uralfoxes.entity.SystemUser;
import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.NoResultException;
import java.security.MessageDigest;
import java.util.Arrays;

//FAI90xnp

@ManagedBean(name = "authority")
@SessionScoped
public class Authority extends DefaultController {

    private SystemUser loggedUser;
    @Getter
    @Setter
    private String login;

    @Getter
    @Setter
    private String password;

    public SystemUser getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(SystemUser loggedUser) {
        this.loggedUser = loggedUser;
    }


    public void logIn() {

        SystemUser dbUser = null;
        try {

            dbUser = (SystemUser) getEntityManager().createQuery("SELECT x FROM SystemUser x where x.login=:login")
                    .setParameter("login", login)
                    .getSingleResult();

            if (Arrays.equals(encodePassword(password), dbUser.getPassword())) {
                setLoggedUser(dbUser);
            }

        } catch (NoResultException e) {

        }


    }


    public byte[] encodePassword(String pass) {
        byte[] res = null;

        try {

            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            res = messageDigest.digest(pass.getBytes());

        } catch (Exception e) {

        }


        return res;
    }


    public void logOut() {
        setLoggedUser(null);
    }

}
