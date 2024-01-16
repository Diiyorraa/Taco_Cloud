package com.example.Test1.Repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.Test1.Models.Users;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {

    Users findByUsername(String username);
}