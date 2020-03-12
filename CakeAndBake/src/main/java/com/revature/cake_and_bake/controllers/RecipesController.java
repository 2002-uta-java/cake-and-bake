package com.revature.cake_and_bake.controllers;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.cake_and_bake.models.Recipe;
import com.revature.cake_and_bake.services.RecipeService;

@RestController
@RequestMapping("/recipes")
public class RecipesController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private RecipeService rcpService;

	@GetMapping
	public List<Recipe> getAllRecipes() {
		return rcpService.getAllRecipes();
	}

}
