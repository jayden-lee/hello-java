package com.jayden.ch04.tacos.repository;

import com.jayden.ch04.tacos.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
