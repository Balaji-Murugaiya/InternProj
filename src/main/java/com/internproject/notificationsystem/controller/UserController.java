package com.internproject.notificationsystem.controller;
import com.internproject.notificationsystem.DTO.LoginData;
import com.internproject.notificationsystem.DTO.UserData;
import com.internproject.notificationsystem.service.GeoIP;
import com.internproject.notificationsystem.service.LocationDetailsService;
import com.internproject.notificationsystem.service.RequestServiceImpl;
import com.internproject.notificationsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


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
    public RedirectView logout(HttpServletRequest request)
    {
        return userService.logout(request);
    }







}
