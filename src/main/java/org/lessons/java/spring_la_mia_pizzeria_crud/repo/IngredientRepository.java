package org.lessons.java.spring_la_mia_pizzeria_crud.repo;

import org.lessons.java.spring_la_mia_pizzeria_crud.model.Ingredient; // Ensure this path matches the actual location of the Ingredient class
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

	
}
