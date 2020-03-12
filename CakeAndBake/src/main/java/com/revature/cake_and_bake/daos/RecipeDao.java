package com.revature.cake_and_bake.daos;

import java.io.Serializable;
import java.util.List;

import com.revature.cake_and_bake.models.Recipe;

public interface RecipeDao extends Serializable {
	public List<Recipe> getAllRecipes();
}
