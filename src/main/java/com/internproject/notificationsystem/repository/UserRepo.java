package com.internproject.notificationsystem.repository;

import com.internproject.notificationsystem.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User,String> {

}
