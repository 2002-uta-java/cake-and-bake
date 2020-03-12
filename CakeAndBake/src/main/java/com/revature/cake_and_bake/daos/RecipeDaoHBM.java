package com.revature.cake_and_bake.daos;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.revature.cake_and_bake.connections.HibernateUtil;
import com.revature.cake_and_bake.models.Recipe;

@Repository
public class RecipeDaoHBM implements RecipeDao {

	private static final long serialVersionUID = 1L;

	@Override
	public List<Recipe> getAllRecipes() {
		try (final Session session = HibernateUtil.getSession()) {
			final CriteriaBuilder cb = session.getCriteriaBuilder();
			final CriteriaQuery<Recipe> cq = cb.createQuery(Recipe.class);

			// root of query is all? from Recipe's table
			final Root<Recipe> root = cq.from(Recipe.class);
			cq.select(root);

			final Query<Recipe> query = session.createQuery(cq);

			return query.list();
		}
	}

}
