package com.internproject.notificationsystem.model;


import com.internproject.notificationsystem.DTO.UserData;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long uID ;
    private String userName ;
    @Column(unique = true)
    private String emailID ;
    private String password ;
    private String gender ;
    private String phoneNumber ;
    private String description ;
    private final boolean activityStatus = true ;

    public User(UserData userData)
    {
        this.setPassword(userData.getPassword());
        this.setUserName(userData.getUserName());
        this.setEmailID(userData.getEmailID());
        this.setGender(userData.getGender());
        this.setDescription(userData.getDescription());
        this.setPhoneNumber(userData.getPhoneNumber());
    }


    public User() {

    }

    @Override
    public String toString() {
        return "Email ID:" + emailID + "\n" + "Name:" + userName + "\n" +
                "Phone number:" + phoneNumber+ "\n" + "gender:" + gender + "\n" +
                "Description:" + description + "\n" ;
    }
}
