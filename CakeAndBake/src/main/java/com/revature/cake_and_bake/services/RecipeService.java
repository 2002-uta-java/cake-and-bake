package com.revature.cake_and_bake.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.cake_and_bake.daos.RecipeDao;
import com.revature.cake_and_bake.models.Ingredient;
import com.revature.cake_and_bake.models.RecipeFull;
import com.revature.cake_and_bake.models.RecipeMinimal;
import com.revature.cake_and_bake.models.RecipeStep;
import com.revature.cake_and_bake.models.js.RecipeJS;

@Service
public class RecipeService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private RecipeDao rcpDao;

	public List<RecipeMinimal> getAllRecipesMinimal() {
		return rcpDao.getAllRecipesMinimal();
	}

	public boolean createRecipe(final RecipeFull recipe) {
		// first we must create the minimal recipe
		final RecipeMinimal rcpMin = new RecipeMinimal(recipe);
		if (rcpDao.createRecipe(rcpMin)) {
			final int rcpId = rcpMin.getId();
			// set id of full recipe
			recipe.setId(rcpId);

			System.err.println();
			System.err.println();
			System.err.println("RecipeService, rcpMin.id: " + rcpId);
			System.err.println();
			System.err.println();
			// now set the foreign keys for all of the ingredients and steps (there
			// shouldn't be any comments on a create)
			final List<Ingredient> ingredients = recipe.getIngredients();
			final List<RecipeStep> steps = recipe.getSteps();

			for (final Ingredient ingredient : ingredients) {
				ingredient.getId().setRecipe(recipe);
			}
			for (final RecipeStep step : steps) {
				step.getId().setRecipe(recipe);
			}

			// finally save full recipe now that all foreign keys have been set
			return rcpDao.createRecipe(recipe);
		} else {
			return false;
		}
	}

	public boolean deleteRecipeById(final int rcpId) {
		return rcpDao.deleteRecipeById(rcpId);
	}

	public RecipeJS getFullRecipeById(final int id) {
		final RecipeFull recipe = rcpDao.getFullRecipeById(id);
		System.err.println();
		System.err.println();
		System.err.println(recipe);
		System.err.println();
		System.err.println();
		return new RecipeJS(recipe);
	}
}
