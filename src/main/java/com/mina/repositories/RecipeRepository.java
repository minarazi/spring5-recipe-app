package com.mina.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mina.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long>{

}
