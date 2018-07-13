package com.mina.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mina.domain.Recipe;
import com.mina.repositories.RecipeRepository;

public class RecipeServiceImplTest {

	RecipeServiceImpl recipeservice;

	@Mock
	RecipeRepository recipeRepository;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		recipeservice = new RecipeServiceImpl(recipeRepository);
	}

	@Test
	public void testGetRecipes() {

		Recipe recipe = new Recipe();
		HashSet recipeData = new HashSet();
		recipeData.add(recipe);

		when(recipeservice.getRecipes()).thenReturn(recipeData);

		Set<Recipe> recipes = recipeservice.getRecipes();
		assertEquals(recipes.size(), 1);
		verify(recipeRepository, times(1)).findAll();
	}

}
