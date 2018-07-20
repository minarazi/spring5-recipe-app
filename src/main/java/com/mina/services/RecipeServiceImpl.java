package com.mina.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.mina.domain.Recipe;
import com.mina.repositories.RecipeRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

	private RecipeRepository recipeRepository;

	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		super();
		this.recipeRepository = recipeRepository;
	}

	@Override
	public Set<Recipe> getRecipes() {

		log.debug("I'm in the service.");
		
		Set<Recipe> recipes = new HashSet<>();

		// Iterable<Recipe> findAll = recipeRepository.findAll();
		// for (Recipe recipe : findAll) {
		// recipes.add(recipe);
		// System.out.println(recipe);
		// }

		recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
		// recipeRepository.findAll().iterator().forEachRemaining(System.out::println);
	
		return recipes;
	}
	
	@Override
	public Recipe findById( Long id) {
		Optional<Recipe> recipe = recipeRepository.findById(id);
		
		if (!recipe.isPresent()) {
			
			throw new RuntimeException("Recipe Not found"); 
		}
		
		return recipe.get();
	}
}
