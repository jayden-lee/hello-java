package com.jayden.ch04.tacos.repository;

import com.jayden.ch04.tacos.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long> {
}
