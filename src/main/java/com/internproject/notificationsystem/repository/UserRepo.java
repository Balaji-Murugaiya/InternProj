package com.internproject.notificationsystem.repository;

import com.internproject.notificationsystem.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User,Long> {
    @Query("SELECT u FROM User u WHERE u.Email_ID = ?1")
    public User findByEmail(String Email_ID);

}
