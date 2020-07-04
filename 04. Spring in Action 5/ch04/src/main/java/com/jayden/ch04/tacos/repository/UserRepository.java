package com.jayden.ch04.tacos.repository;

import com.jayden.ch04.tacos.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
