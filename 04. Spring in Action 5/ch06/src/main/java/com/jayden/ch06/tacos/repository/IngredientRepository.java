package com.jayden.ch06.tacos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayden.ch06.tacos.entity.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, String> {

}
