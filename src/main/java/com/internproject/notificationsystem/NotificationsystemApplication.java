package com.internproject.notificationsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication()
public class NotificationsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationsystemApplication.class, args);
    }

}
