package com.internproject.notificationsystem.service;

import com.internproject.notificationsystem.model.User;
import com.internproject.notificationsystem.repository.UserRepository;
import com.internproject.notificationsystem.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username) ;
        if(user == null)
        {
            throw new UsernameNotFoundException(username) ;
        }

        return new CustomUserDetails(user);
    }
}
