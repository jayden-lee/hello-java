package com.jayden.ch06.tacos.web.api;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.jayden.ch06.tacos.entity.Ingredient;
import com.jayden.ch06.tacos.entity.Ingredient.Type;
import lombok.Getter;

@Getter
@Relation(value = "ingredient", collectionRelation = "ingredients")
public class IngredientModel extends RepresentationModel<IngredientModel> {

  private final String name;
  private final Type type;

  public IngredientModel(Ingredient ingredient) {
    this.name = ingredient.getName();
    this.type = ingredient.getType();
  }
}
