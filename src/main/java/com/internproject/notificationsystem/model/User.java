package com.internproject.notificationsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
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

    public String getEmail_ID() {
        return Email_ID;
    }

    public void setEmail_ID(String email_ID) {
        Email_ID = email_ID;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public long getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(long phone_Number) {
        Phone_Number = phone_Number;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getActivity_Status() {
        return Activity_Status;
    }

    public void setActivity_Status(String activity_Status) {
        Activity_Status = activity_Status;
    }





}
