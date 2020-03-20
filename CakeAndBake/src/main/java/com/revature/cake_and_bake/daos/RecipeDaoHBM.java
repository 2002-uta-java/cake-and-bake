package com.revature.cake_and_bake.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.cake_and_bake.models.RecipeFull;
import com.revature.cake_and_bake.models.RecipeMinimal;
import com.revature.cake_and_bake.models.join_table.CommentAssociation;
import com.revature.cake_and_bake.models.join_table.IngredientAssociation;
import com.revature.cake_and_bake.models.join_table.Recipe;
import com.revature.cake_and_bake.models.join_table.RecipeStepAssociation;

@Repository
public class RecipeDaoHBM implements RecipeDao {

	private static final long serialVersionUID = 1L;

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public List<RecipeMinimal> getAllRecipesMinimal() {
		final Session session = sessionFactory.getCurrentSession();
		final List<RecipeMinimal> recipes = session.createQuery("from RecipeMinimal").list();
		return recipes;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public Recipe getFullRecipeById(final int id) {
		final Session session = sessionFactory.getCurrentSession();
		final Recipe recipe = (Recipe) session.get(Recipe.class, id);
		return recipe;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public boolean createRecipe(RecipeMinimal recipe) {
		final Session session = sessionFactory.getCurrentSession();
		return session.save(recipe) != null;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public boolean createRecipe(RecipeFull recipe) {
		final Session session = sessionFactory.getCurrentSession();
		deleteRecipeById(recipe.getId());
		return session.save(recipe) != null;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public boolean deleteRecipeById(int rcpId) {
		final Session session = sessionFactory.getCurrentSession();

		final RecipeFull recipe = (RecipeFull) session.load(RecipeFull.class, rcpId);
		System.err.println();
		System.err.println();
		System.err.println("Loaded Recipe (to be deleted): " + recipe);
		System.err.println();
		System.err.println();
		if (recipe != null) {
			session.delete(recipe);
			return true;
		} else {
			return false;
		}
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public boolean createRecipe(Recipe recipe) {
		final Session session = sessionFactory.getCurrentSession();
		final List<RecipeStepAssociation> steps = recipe.getSteps();
		final List<IngredientAssociation> ingredients = recipe.getIngredients();
		final List<CommentAssociation> comments = recipe.getComments();

		recipe.setSteps(null);
		recipe.setIngredients(null);
		recipe.setComments(null);

		// save recipe without its lists
		session.save(recipe);

		final int rcpId = recipe.getRcpId();

		// now go through each of the items and set the key
		for (final RecipeStepAssociation step : steps) {
			step.setRcpId(rcpId);
		}
		for (final IngredientAssociation ingredient : ingredients) {
			ingredient.setRcpId(rcpId);
		}
		for (final CommentAssociation comment : comments) {
			comment.setRcpId(rcpId);
		}

		recipe.setSteps(steps);
		recipe.setIngredients(ingredients);
		recipe.setComments(comments);

		// now save it with the updated values
		session.save(recipe);
		return true;
	}
}
