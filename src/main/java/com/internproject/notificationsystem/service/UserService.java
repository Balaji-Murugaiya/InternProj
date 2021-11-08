package com.internproject.notificationsystem.service;

import com.internproject.notificationsystem.DTO.LoginData;
import com.internproject.notificationsystem.DTO.UserData;
import com.internproject.notificationsystem.model.User;
import com.internproject.notificationsystem.repository.UserRepository;
import org.jasypt.util.text.BasicTextEncryptor;
import org.jasypt.util.text.TextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.session.SessionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


import static org.springframework.http.HttpStatus.UNAUTHORIZED;


@Service
public class UserService {

    @Autowired
    PasswordEncoder passwordEncoder ;

    @Autowired
    UserRepository userRepository ;

    @Autowired
    LocationDetailsService locationDetailsService ;

    @Autowired
    RequestServiceImpl requestService ;

    
    @Autowired
    SessionRepository<?> sessionRepository;

    @Autowired
    EmailSender emailSender ;

    @Autowired
    TextEncryptor textEncryptor ;


    private GeoIP geoIP ;

    public void register(UserData userData) throws IOException
    {
        userData.setPassword(passwordEncoder.encode(userData.getPassword()));
        User newUser = new User(userData) ;
        userRepository.save(newUser) ;

    }

    public String login(LoginData loginData  , HttpServletRequest request) throws Exception
    {

        User user = userRepository.findByEmail(loginData.getEmailID());
        if(user == null)
        {
            throw new UsernameNotFoundException(loginData.getEmailID());
        }
        if(!(passwordEncoder.matches(loginData.getPassword(), user.getPassword())))
        {
            throw new ResponseStatusException(UNAUTHORIZED);
        }
        HttpSession httpSession = request.getSession() ;
        httpSession.setAttribute("emailID",loginData.getEmailID());
        geoIP = locationDetailsService.getLocation(requestService.getClientIp(request)) ;
        httpSession.setAttribute("ipAddress" , geoIP.getIpAddress());
        httpSession.setAttribute("City",geoIP.getCity());
        httpSession.setAttribute("Latitude",geoIP.getLatitude());
        httpSession.setAttribute("Longitude",geoIP.getLongitude());
        String encodedSessionID = textEncryptor.encrypt(httpSession.getId());
        emailSender.sendEmail(loginData.getEmailID() , geoIP , encodedSessionID);
        return  "login success!"  ;
    }

    public String currentUser(HttpServletRequest request) throws Exception
    {
        HttpSession session = request.getSession();
        String emailID =  (String)session.getAttribute("emailID") ;
        if(emailID == null)
            throw new AuthorizationServiceException("unauthorized");
        User currentUserDetails =  userRepository.findByEmail(emailID) ;
        return currentUserDetails.toString() ;
    }

    public RedirectView logout(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(-1);
        return new RedirectView("index.html") ;
    }

    public void logoutFromMail( HttpServletRequest request)
    {
        String requestURL = request.getRequestURL().toString() ;
        String ID =  requestURL.split("/lo/")[1] ;
        String decodedID = textEncryptor.decrypt(ID);
        sessionRepository.deleteById(decodedID);

    }

}
