package com.internproject.notificationsystem.controller;


import com.internproject.notificationsystem.DTO.LoginData;
import com.internproject.notificationsystem.DTO.UserData;
import com.internproject.notificationsystem.model.User;
import com.internproject.notificationsystem.security.CustomUserDetails;
import com.internproject.notificationsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @Autowired
    UserService userService ;

    @GetMapping("/currentUser")
    public String userDetail(@AuthenticationPrincipal CustomUserDetails customUserDetails)
    {
        String des = customUserDetails.getDes() ;
        return des ;
    }

    @PostMapping("/register")
    public void registeration(@RequestBody UserData userData ) throws Exception
    {
        userService.register(userData);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginData loginData , HttpServletRequest request) throws Exception
    {

        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("emailID",loginData.getEmailID());
        httpSession.setAttribute("ipAddress" , request.getRemoteAddr());
        return userService.login(loginData) ;



    }

}
