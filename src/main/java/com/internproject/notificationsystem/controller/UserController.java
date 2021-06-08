package com.internproject.notificationsystem.controller;


import com.internproject.notificationsystem.DTO.LoginData;
import com.internproject.notificationsystem.DTO.UserData;
import com.internproject.notificationsystem.security.CustomUserDetails;
import com.internproject.notificationsystem.service.RequestServiceImpl;
import com.internproject.notificationsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
public class UserController {

    @Autowired
    UserService userService ;
    @Autowired
    RequestServiceImpl requestService ;

    @GetMapping("/currentUser")
    public String userDetail(HttpServletRequest request)
    {

        return request.getHeader("X-FORWARDED-FOR") ;
    }

    @PostMapping("/register")
    public void registeration(@RequestBody UserData userData ) throws IOException
    {
        userService.register(userData);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginData loginData , HttpServletRequest request) throws Exception
    {

        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("emailID",loginData.getEmailID());
        httpSession.setAttribute("ipAddress" , requestService.getClientIp(request));
        return userService.login(loginData)  + httpSession.getAttribute("ipAddress");



    }

}
