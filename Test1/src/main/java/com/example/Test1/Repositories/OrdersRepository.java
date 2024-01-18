package com.example.Test1.Repositories;
import com.example.Test1.Models.Orders;

import com.example.Test1.Models.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@EnableJpaRepositories
@Repository
public interface OrdersRepository extends CrudRepository <Orders, Long> {

    Page<Orders> findByUserIdOrderByPlacedAtDesc(Users userId, Pageable page);
}
