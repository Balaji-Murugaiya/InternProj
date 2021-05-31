package com.internproject.notificationsystem.controller;

import com.internproject.notificationsystem.model.LoginDTO;
import com.internproject.notificationsystem.model.User;
import com.internproject.notificationsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userservice ;

    @PostMapping("/register")
    void register(@RequestBody User user)
    {

        userservice.register(user);
    }

    @PostMapping("/login")
    User login(@RequestBody LoginDTO logindto) throws Exception {
        return userservice.login(logindto) ;
    }

}
