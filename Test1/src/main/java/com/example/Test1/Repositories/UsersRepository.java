package com.example.Test1.Repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.Test1.Models.Users;

public interface UsersRepository extends CrudRepository<Users, Long> {

    Users findByUsername(String username);

}