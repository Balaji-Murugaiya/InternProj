package com.internproject.notificationsystem.security;

import org.jasypt.util.text.BasicTextEncryptor;
import org.jasypt.util.text.StrongTextEncryptor;
import org.jasypt.util.text.TextEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig {

    @Bean
    PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder(10) ;
    }

    @Bean
    public TextEncryptor textEncryptor()
    {
        BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor() ;
        basicTextEncryptor.setPassword("abc123");
        return basicTextEncryptor ;
    }



}
