package com.internproject.notificationsystem.service;

import com.internproject.notificationsystem.DTO.LoginData;
import com.internproject.notificationsystem.DTO.UserData;
import com.internproject.notificationsystem.model.User;
import com.internproject.notificationsystem.repository.UserRepository;
import javassist.NotFoundException;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.security.auth.login.CredentialException;
import javax.security.auth.message.AuthException;
import java.io.IOException;
import java.net.http.HttpResponse;

@Service
public class UserService {

    @Autowired
    PasswordEncoder passwordEncoder ;

    @Autowired
    UserRepository userRepository ;

    public void register(UserData userData) throws IOException
    {
        userData.setPassword(passwordEncoder.encode(userData.getPassword()));
        User newUser = new User(userData) ;
        userRepository.save(newUser) ;

    }

    public String login(LoginData loginData) throws Exception
    {

        User user = userRepository.findByEmail(loginData.getEmailID());
        if(user == null)
        {
            throw new UsernameNotFoundException(loginData.getEmailID());
        }
        if(!(passwordEncoder.matches(loginData.getPassword(), user.getPassword())))
        {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);

        }
        return user.getDescription() ;
    }
}
