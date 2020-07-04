package com.jayden.ch04.tacos.repository;

import com.jayden.ch04.tacos.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
