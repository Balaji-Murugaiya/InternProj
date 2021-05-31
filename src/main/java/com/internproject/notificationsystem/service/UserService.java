package com.internproject.notificationsystem.service;


import com.internproject.notificationsystem.model.LoginDTO;
import com.internproject.notificationsystem.model.User;
import com.internproject.notificationsystem.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService  {

    @Autowired
    UserRepo userrepo ;

    public void register(User user)
    {

        userrepo.save(user) ;
    }

    public User login(LoginDTO logindto) throws Exception
    {

        User currentUser = new User();
        currentUser = userrepo.findByEmail(logindto.getEmail_ID()) ;
        if(currentUser.equals(null))
        {
            throw UsernameNotFoundException("User name does not exist") ;
        }
        if (currentUser.getEmail_ID().equals(logindto.getEmail_ID()) && currentUser.getPassword().equals(logindto.getPassword()))
        {
            throw new Exception("Password is wrong") ;
        }
        return currentUser ;









        }




}




