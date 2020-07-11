package com.jayden.ch06.tacos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jayden.ch06.tacos.entity.Ingredient;
import com.jayden.ch06.tacos.entity.Ingredient.Type;
import com.jayden.ch06.tacos.entity.Taco;
import com.jayden.ch06.tacos.repository.IngredientRepository;
import com.jayden.ch06.tacos.repository.TacoRepository;

import java.util.Arrays;

@Profile("!prod")
@Configuration
public class MockDataLoader {

  @Bean
  public CommandLineRunner dataLoader(IngredientRepository ingredientRepository, TacoRepository tacoRepository) {
    return args -> {
      Ingredient flourTortilla = new Ingredient("FLTO", "Flour Tortilla", Type.WRAP);
      Ingredient cornTortilla = new Ingredient("COTO", "Corn Tortilla", Type.WRAP);
      Ingredient groundBeef = new Ingredient("GRBF", "Ground Beef", Type.PROTEIN);
      Ingredient carnitas = new Ingredient("CARN", "Carnitas", Type.PROTEIN);
      Ingredient tomatoes = new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES);
      Ingredient lettuce = new Ingredient("LETC", "Lettuce", Type.VEGGIES);
      Ingredient cheddar = new Ingredient("CHED", "Cheddar", Type.CHEESE);
      Ingredient jack = new Ingredient("JACK", "Monterrey Jack", Type.CHEESE);
      Ingredient salsa = new Ingredient("SLSA", "Salsa", Type.SAUCE);
      Ingredient sourCream = new Ingredient("SRCR", "Sour Cream", Type.SAUCE);
      ingredientRepository.save(flourTortilla);
      ingredientRepository.save(cornTortilla);
      ingredientRepository.save(groundBeef);
      ingredientRepository.save(carnitas);
      ingredientRepository.save(tomatoes);
      ingredientRepository.save(lettuce);
      ingredientRepository.save(cheddar);
      ingredientRepository.save(jack);
      ingredientRepository.save(salsa);
      ingredientRepository.save(sourCream);

      tacoRepository.save(new Taco("TACO_SAMPLE_1", Arrays.asList(flourTortilla, cornTortilla)));
      tacoRepository.save(new Taco("TACO_SAMPLE_2", Arrays.asList(cornTortilla, carnitas, jack)));
      tacoRepository.save(new Taco("TACO_SAMPLE_3", Arrays.asList(lettuce, salsa, sourCream)));
      tacoRepository.save(new Taco("TACO_SAMPLE_4", Arrays.asList(lettuce, jack)));
      tacoRepository.save(new Taco("TACO_SAMPLE_5", Arrays.asList(cornTortilla, carnitas, sourCream)));
    };
  }
}
