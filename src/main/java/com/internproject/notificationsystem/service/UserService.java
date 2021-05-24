package com.internproject.notificationsystem.service;


import com.internproject.notificationsystem.model.User;
import com.internproject.notificationsystem.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService  {

    @Autowired
    UserRepo userrepo ;

    public void save(User user)
    {
        userrepo.save(user) ;
    }

    public List<User> getAll()
    {
        List<User> temp= new ArrayList<User>() ;
        userrepo.findAll().forEach(user1->temp.add(user1));
        return temp ;
    }



}
