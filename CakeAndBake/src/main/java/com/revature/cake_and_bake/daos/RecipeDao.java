package com.revature.cake_and_bake.daos;

import java.io.Serializable;
import java.util.List;

import com.revature.cake_and_bake.models.RecipeFull;
import com.revature.cake_and_bake.models.RecipeMinimal;

public interface RecipeDao extends Serializable {
	public List<RecipeMinimal> getAllRecipesMinimal();

	public RecipeFull getFullRecipeById(int id);

	public boolean createRecipe(RecipeMinimal recipe);

	/**
	 * For this method to be successful, the passed recipe must already have all of
	 * the foreign keys set. Really, first you need to create the minimal recipe.
	 * 
	 * @param recipe
	 * @return
	 */
	public boolean createRecipe(RecipeFull recipe);

	public boolean deleteRecipeById(int rcpId);
}
