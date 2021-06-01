package com.internproject.notificationsystem.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class User {

    @Id
    @Column
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long UID ;



    @Column(nullable = false , unique = true)
    private String Email_ID ;


    @Column(nullable = false)
    private String User_Name;

    @Column(nullable = false)
    private String Password ;

    @Column(nullable = false)
    private String Gender ;

    @Column(nullable = false)
    private long Phone_Number ;

    @Column(nullable = true)
    private String Description ;

    @Column
    private String Activity_Status ;



}
