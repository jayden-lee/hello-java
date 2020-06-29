package com.jayden.ch03.tacos.repository;

import com.jayden.ch03.tacos.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
