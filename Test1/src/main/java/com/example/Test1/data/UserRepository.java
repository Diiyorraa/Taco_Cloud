package com.example.Test1.data;

import org.springframework.data.repository.CrudRepository;
import com.example.Test1.Users;

public interface UserRepository extends CrudRepository<Users, Long> {

    Users findByUsername(String username);

}