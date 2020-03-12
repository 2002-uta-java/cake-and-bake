package com.revature.cake_and_bake.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.cake_and_bake.daos.RecipeDao;
import com.revature.cake_and_bake.models.Recipe;

@Service
public class RecipeService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private RecipeDao rcpDao;

	public List<Recipe> getAllRecipes() {
		return rcpDao.getAllRecipes();
	}
}
