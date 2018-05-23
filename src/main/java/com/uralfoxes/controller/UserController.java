package com.uralfoxes.controller;

import com.uralfoxes.entity.SystemUser;
import com.uralfoxes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author Sergei W Adonev ( admin@cnlist.us)
 *
 */
@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    UserRepository userRepository;


    /**
     * This is Transport Password. You should change it befor using site
     *
     * @return
     * @throws NoSuchAlgorithmException
     */
    @RequestMapping(value = "init", method = RequestMethod.GET)
    public @ResponseBody
    String initFirstUser() throws NoSuchAlgorithmException {

        SystemUser user = new SystemUser();
        user.setEnabled(true);
        user.setLogin("admin");

        MessageDigest digest = MessageDigest.getInstance("SHA1");
        user.setPassword(digest.digest(new String("Bw/9*As18BQ").getBytes()));
        userRepository.create(user);

        return "ok";
    }

}
