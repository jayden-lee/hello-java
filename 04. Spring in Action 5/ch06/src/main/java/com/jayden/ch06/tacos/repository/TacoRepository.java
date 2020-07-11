package com.jayden.ch06.tacos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayden.ch06.tacos.entity.Taco;

public interface TacoRepository extends JpaRepository<Taco, Long> {

}
