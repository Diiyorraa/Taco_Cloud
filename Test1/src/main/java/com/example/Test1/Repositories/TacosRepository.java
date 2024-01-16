package com.example.Test1.Repositories;


import com.example.Test1.Models.Tacos;


import org.springframework.data.repository.CrudRepository;


public interface TacosRepository
        extends CrudRepository<Tacos, Long> {

}