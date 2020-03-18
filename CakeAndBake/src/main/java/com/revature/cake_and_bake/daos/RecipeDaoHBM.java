package com.revature.cake_and_bake.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.cake_and_bake.models.Recipe;

@Repository
public class RecipeDaoHBM implements RecipeDao {

	private static final long serialVersionUID = 1L;

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public List<Recipe> getAllRecipes() {
		final Session session = sessionFactory.getCurrentSession();
		final List<Recipe> recipes = session.createQuery("from Recipe").list();
		return recipes;
	}

}
