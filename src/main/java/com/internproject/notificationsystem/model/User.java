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



    @Column
    private String Email_ID ;


    @Column
    private String User_Name;

    @Column
    private String Password ;

    @Column
    private String Gender ;

    @Column
    private long Phone_Number ;

    @Column
    private String Description ;

    @Column
    private String Activity_Status ;



}
