package com.internproject.notificationsystem.controller;


import com.internproject.notificationsystem.DTO.UserData;
import com.internproject.notificationsystem.model.User;
import com.internproject.notificationsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService ;

    @PostMapping("/register")
    public void registeration(@RequestBody UserData userData)
    {
        userService.register(userData);
    }

}
