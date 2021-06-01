package com.internproject.notificationsystem.service;

import com.internproject.notificationsystem.model.CustomUserDetails;
import com.internproject.notificationsystem.model.User;
import com.internproject.notificationsystem.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserRepo userrepo ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userrepo.findByEmail(username);
        if(user == null)
        {
            throw new UsernameNotFoundException("User does not exist!") ;
        }
        return new CustomUserDetails(user) ;
    }
}
