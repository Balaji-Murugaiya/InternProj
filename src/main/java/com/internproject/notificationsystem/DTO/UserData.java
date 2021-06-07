package com.internproject.notificationsystem.DTO;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserData {

    @NotNull
    private String userName ;
    @NotNull
    private String emailID ;
    @NotNull
    private String password ;
    @NotNull
    private String gender ;
    @NotNull
    private String phoneNumber ;
    @NotNull
    private String description ;

}
