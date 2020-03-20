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
	public RecipeFull getFullRecipeById(final int id) {
		final Session session = sessionFactory.getCurrentSession();
		return (RecipeFull) session.get(RecipeFull.class, id);
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
}
