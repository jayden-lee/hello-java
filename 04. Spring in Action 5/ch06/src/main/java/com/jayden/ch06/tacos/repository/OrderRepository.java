package com.jayden.ch06.tacos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayden.ch06.tacos.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
