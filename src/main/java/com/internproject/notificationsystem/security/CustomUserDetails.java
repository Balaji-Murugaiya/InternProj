package com.internproject.notificationsystem.security;

import com.internproject.notificationsystem.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {
    private User user ;

    public CustomUserDetails(User user)
    {
        this.user = user ;

    }

    public String getDes()
    {
        return user.getDescription() ;
    }

    @Override
    public String getUsername() {
        return user.getEmailID() ;
    }

    @Override
    public String getPassword() {
        return user.getPassword() ;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public CustomUserDetails() {
        super();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
