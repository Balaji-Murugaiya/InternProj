package com.internproject.notificationsystem.service;

import com.internproject.notificationsystem.DTO.UserData;
import com.internproject.notificationsystem.model.User;
import com.internproject.notificationsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    PasswordEncoder passwordEncoder ;

    @Autowired
    UserRepository userRepository ;

    public void register(UserData userData)
    {
        userData.setPassword(passwordEncoder.encode(userData.getPassword()));
        User newUser = new User(userData) ;
        userRepository.save(newUser) ;

    }
}
