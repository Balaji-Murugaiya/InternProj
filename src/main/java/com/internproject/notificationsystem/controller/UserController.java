package com.internproject.notificationsystem.controller;


import com.internproject.notificationsystem.DTO.LoginData;
import com.internproject.notificationsystem.DTO.UserData;
import com.internproject.notificationsystem.model.User;
import com.internproject.notificationsystem.security.CustomUserDetails;
import com.internproject.notificationsystem.service.GeoIP;
import com.internproject.notificationsystem.service.LocationDetailsService;
import com.internproject.notificationsystem.service.RequestServiceImpl;
import com.internproject.notificationsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class UserController {

    @Autowired
    UserService userService ;
    @Autowired
    RequestServiceImpl requestService ;

    @Autowired
    LocationDetailsService locationDetailsService ;

    private GeoIP geoIP ;



    @PostMapping("/register")
    public void registeration(@RequestBody UserData userData ) throws IOException
    {
        userService.register(userData);
    }

    @PostMapping("/login")
    public void login(@RequestBody LoginData loginData , HttpServletRequest request) throws Exception
    {

        userService.login(loginData, request)  ;



    }

    @GetMapping("/currentUser")
    public String currentUser(HttpServletRequest request) throws Exception
    {
        return userService.currentUser(request) ;
    }

    @PatchMapping ("/logout")
    public String logout(HttpServletRequest request)
    {
        return userService.logout(request);
    }







}
