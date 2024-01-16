package com.example.Test1.Repositories;
import com.example.Test1.Models.Orders;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrdersRepository extends CrudRepository<Orders, Long> {

}