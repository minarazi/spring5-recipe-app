package com.mina.bootstrap;

import java.math.BigDecimal;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.mina.domain.Category;
import com.mina.domain.Difficulty;
import com.mina.domain.Ingredient;
import com.mina.domain.Notes;
import com.mina.domain.Recipe;
import com.mina.domain.UniteOfMeasure;
import com.mina.repositories.CategoryRepository;
import com.mina.repositories.RecipeRepository;
import com.mina.repositories.UniteOfMeasureRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	private UniteOfMeasureRepository uniteOfMeasureRepository;
	private CategoryRepository categoryRepository;
	private RecipeRepository recipeRepository;

	public RecipeBootstrap(UniteOfMeasureRepository uniteOfMeasureRepository, CategoryRepository categoryRepository,
			RecipeRepository recipeRepository) {
		super();
		this.uniteOfMeasureRepository = uniteOfMeasureRepository;
		this.categoryRepository = categoryRepository;
		this.recipeRepository = recipeRepository;
	}

	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		Recipes();
		
		log.debug("loading bootstrap data");
	}

	private void Recipes() {

		// Find Cup UOM from db.
		Optional<UniteOfMeasure> cupUomOptional = uniteOfMeasureRepository.findByUom("Cup");
		if (!cupUomOptional.isPresent()) {
			throw new RuntimeException("Expected UOM Not Found");
		}
		Optional<UniteOfMeasure> teaspoonUomOptional = uniteOfMeasureRepository.findByUom("Teaspoon");
		if (!teaspoonUomOptional.isPresent()) {
			throw new RuntimeException("Expected UOM Not Found");
		}

		Optional<UniteOfMeasure> tablespoonUomOptional = uniteOfMeasureRepository.findByUom("Tablespoon");
		if (!tablespoonUomOptional.isPresent()) {
			throw new RuntimeException("Expected UOM Not Found");
		}

		Optional<UniteOfMeasure> pinchUomOptional = uniteOfMeasureRepository.findByUom("Pinch");
		if (!pinchUomOptional.isPresent()) {
			throw new RuntimeException("Expected UOM Not Found");
		}

		Optional<UniteOfMeasure> ounceUomOptional = uniteOfMeasureRepository.findByUom("Ounce");
		if (!ounceUomOptional.isPresent()) {
			throw new RuntimeException("Expected UOM Not Found");
		}

		Optional<UniteOfMeasure> eachUomOptional = uniteOfMeasureRepository.findByUom("Each");
		if (!eachUomOptional.isPresent()) {
			throw new RuntimeException("Expected UOM Not Found");
		}

		Optional<UniteOfMeasure> dashUomOptional = uniteOfMeasureRepository.findByUom("Dash");
		if (!dashUomOptional.isPresent()) {
			throw new RuntimeException("Expected UOM Not Found");
		}

		Optional<UniteOfMeasure> pintUomOptional = uniteOfMeasureRepository.findByUom("Pint");
		if (!pintUomOptional.isPresent()) {
			throw new RuntimeException("Expected UOM Not Found");
		}

		UniteOfMeasure cupUom = cupUomOptional.get();
		UniteOfMeasure teaspoonUom = teaspoonUomOptional.get();
		UniteOfMeasure tablespoonUom = tablespoonUomOptional.get();
		UniteOfMeasure pinchUom = pinchUomOptional.get();
		UniteOfMeasure ounceUom = ounceUomOptional.get();
		UniteOfMeasure eachUom = eachUomOptional.get();
		UniteOfMeasure dashUom = dashUomOptional.get();
		UniteOfMeasure pintUom = pintUomOptional.get();

		Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");
		if (!americanCategoryOptional.isPresent()) {
			throw new RuntimeException("Expected Category Not Found");
		}

		Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");
		if (!mexicanCategoryOptional.isPresent()) {
			throw new RuntimeException("Expected Category Not Found");
		}
		Category americaCategory = americanCategoryOptional.get();
		Category mexicanCategory = mexicanCategoryOptional.get();

		// create new recipe
		Recipe guaRecipe = new Recipe();
		guaRecipe.setDescription("Perfect Guacamole");
		guaRecipe.setPrepTime(10);
		guaRecipe.setCookTime(30);
		guaRecipe.setDifficulty(Difficulty.EASY);
		guaRecipe.setDirections(
				"1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon"
						+ "\n"
						+ "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)"
						+ "\n"
						+ "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n"
						+ "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n"
						+ "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n"
						+ "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n"
						+ "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n"
						+ "\n" + "\n"
						+ "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvpiV9Sd");

		Notes guaNotes = new Notes();
		guaNotes.setRecipNotes(
				"For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n"
						+ "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries.\n"
						+ "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n"
						+ "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n"
						+ "\n" + "\n"
						+ "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvoun5ws");
		
		guaRecipe.setNotes(guaNotes);
		
		guaRecipe.setServings(20);
		guaRecipe.setUrl("http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvpiV9Sd");
		guaRecipe.setSource("simplyrecipes");
		

		guaRecipe.addIngredient(new Ingredient("ripe avocados", new BigDecimal(2), eachUom));
		guaRecipe.addIngredient(new Ingredient("Kosher salt", new BigDecimal(0.5), teaspoonUom));
		guaRecipe.addIngredient(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(2), tablespoonUom));
		guaRecipe.addIngredient(
				new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2), tablespoonUom));
		guaRecipe.addIngredient(
				new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2), eachUom));
		guaRecipe.addIngredient(new Ingredient("Cilantro", new BigDecimal(2), tablespoonUom));
		guaRecipe.addIngredient(new Ingredient("freshly grated black pepper", new BigDecimal(2), dashUom));
		guaRecipe.addIngredient(
				new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(".5"), eachUom));

		guaRecipe.getCategories().add(mexicanCategory);
		guaRecipe.getCategories().add(americaCategory);

		recipeRepository.save(guaRecipe);

		Recipe gctRecipe = new Recipe();
		gctRecipe.setDescription("Spicy Grilled Chicken Tacos");
		gctRecipe.setPrepTime(15);
		gctRecipe.setCookTime(30);
		gctRecipe.setDifficulty(Difficulty.MODERAT);

		gctRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat." + "\n"
				+ "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.Set aside to marinate while the grill heats and you prepare the rest of the toppings."
				+ "\n"
				+ "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes. \n"
				+ ".\n"
				+ "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n"
				+ "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n"
				+ "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.\n"
				+ "\n" + "\n" + "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvpiV9Sd");

		Notes gctNotes = new Notes();
		gctNotes.setRecipNotes("We have a family motto and it is this: Everything goes better in a tortilla.\r\n"
				+ "\r\n" + "\n"
				+ " Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house."
				+ "\n" + "Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!"
				+ "\n"
				+ "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings."
				+ "\n"
				+ "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!);\r\n");

		gctRecipe.setNotes(gctNotes);

		gctRecipe.addIngredient(new Ingredient("Cumin", new BigDecimal(1), teaspoonUom));
		gctRecipe.addIngredient(new Ingredient("Oregano", new BigDecimal(1), teaspoonUom));
		gctRecipe.addIngredient(new Ingredient("ancho chili powder", new BigDecimal(2), tablespoonUom));
		gctRecipe.addIngredient(new Ingredient("sugar", new BigDecimal(1), teaspoonUom));
		gctRecipe.addIngredient(new Ingredient("salt", new BigDecimal(0.5), teaspoonUom));
		gctRecipe.addIngredient(new Ingredient("Cilantro", new BigDecimal(2), tablespoonUom));
		gctRecipe.addIngredient(new Ingredient("freshly grated black pepper", new BigDecimal(2), dashUom));
		gctRecipe.addIngredient(
				new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(".5"), eachUom));

		gctRecipe.getCategories().add(mexicanCategory);
		gctRecipe.getCategories().add(americaCategory);

		recipeRepository.save(gctRecipe);

	}

}
