package com.revature.cake_and_bake.controllers;

import java.io.Serializable;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.cake_and_bake.models.RecipeFull;
import com.revature.cake_and_bake.models.RecipeMinimal;
import com.revature.cake_and_bake.models.join_table.Recipe;
import com.revature.cake_and_bake.models.js.RecipeJS;
import com.revature.cake_and_bake.models.js.RecipeMinimalJS;
import com.revature.cake_and_bake.services.RecipeService;

@RestController
@RequestMapping("/recipes")
public class RecipesController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private RecipeService rcpService;

	@GetMapping
	public List<RecipeMinimalJS> getAllRecipesMinimal(final HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");

		final List<RecipeMinimal> recipes = rcpService.getAllRecipesMinimal();
		System.err.println();
		System.err.println();
		System.err.println(recipes);
		System.err.println();
		System.err.println();
		return recipes.stream().map(RecipeMinimalJS::new).collect(Collectors.toList());
	}

	@GetMapping("/full/{id}")
	public RecipeJS getFullRecipeById(@PathVariable("id") final int id) {
		final RecipeJS recipe = rcpService.getFullRecipeById(id);
		System.err.println();
		System.err.println();
		System.err.println(recipe);
		System.err.println();
		System.err.println();
		return recipe;
	}

	@PostMapping
	public ResponseEntity<RecipeFull> createRecipe(@RequestBody final RecipeJS recipeJS,
			final HttpServletRequest request) {
		System.err.println();
		System.err.println();
		System.err.println("Printing RecipeJS object received");
		System.err.println(recipeJS);
		System.err.println();
		System.err.println();

		// convert recipeJs to a Recipe entity
//		final RecipeFull recipe = new RecipeFull(recipeJS);
		final Recipe recipe = new Recipe(recipeJS);

		System.err.println(recipe);
		System.err.println();
		System.err.println();

		if (rcpService.createRecipe(recipe)) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/delete/{rcpId}")
	public ResponseEntity<String> deleteRecipeById(@PathVariable("rcpId") final int rcpId) {
		if (rcpService.deleteRecipeById(rcpId)) {
			return new ResponseEntity<>("deleted recipe id: " + rcpId, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("failed to delete recipe id: " + rcpId, HttpStatus.NOT_FOUND);
		}
	}

}
