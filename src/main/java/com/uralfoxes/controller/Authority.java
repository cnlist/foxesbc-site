package com.uralfoxes.controller;

import com.uralfoxes.entity.SystemUser;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.*;
import java.security.MessageDigest;

//FAI90xnp

@ManagedBean(name = "authority")
@SessionScoped

public class Authority extends DefaultController {


    public void testAuth() throws NamingException, HeuristicRollbackException, RollbackException, HeuristicMixedException, SystemException, NotSupportedException {
        System.out.println("registering user...");
        SystemUser user = new SystemUser();
        user.setLogin("admin");
        user.setEnabled(true);
        user.setPassword(encodePassword("FAI90xnp"));

        UserTransaction transaction = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
        transaction.begin();
        getEntityManager().persist(user);
        transaction.commit();


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

}
