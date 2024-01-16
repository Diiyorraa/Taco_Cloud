package com.example.Test1.data;


import com.example.Test1.Taco;


import org.springframework.data.repository.CrudRepository;


public interface TacoRepository
        extends CrudRepository<Taco, Long> {

}