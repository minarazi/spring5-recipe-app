package com.mina.services;

import java.util.Set;

import com.mina.domain.Recipe;

public interface RecipeService {

	public Set<Recipe> getRecipes();

	Recipe findById(Long id);
}
