package com.example.Test1.Repositories;
import com.example.Test1.Models.Orders;

import org.springframework.data.repository.CrudRepository;


public interface OrdersRepository
        extends CrudRepository<Orders, Long> {

}