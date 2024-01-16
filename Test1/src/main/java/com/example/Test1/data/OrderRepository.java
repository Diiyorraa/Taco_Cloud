package com.example.Test1.data;
import com.example.Test1.Order;

import org.springframework.data.repository.CrudRepository;


public interface OrderRepository
        extends CrudRepository<Order, Long> {

}