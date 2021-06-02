package com.internproject.notificationsystem.repository;

import com.internproject.notificationsystem.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User ,Long> {
    @Query("SELECT u FROM User u WHERE u.emailID = ?1")
    public User findByEmail(String emailID);
}

