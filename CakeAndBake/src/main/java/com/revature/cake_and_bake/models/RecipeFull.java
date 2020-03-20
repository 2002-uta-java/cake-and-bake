package com.revature.cake_and_bake.models;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.revature.cake_and_bake.models.js.IngredientJS;
import com.revature.cake_and_bake.models.js.RecipeJS;

/**
 * This class can be used to pull a full recipe (everything) <em>and</em> to
 * delete a full recipe. The recipe id needs to be specified to use this method.
 * 
 * @author Jared F Bennatt
 *
 */
@Component
@Entity
@Table(name = "recipes")
public class RecipeFull implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "rcp_id", insertable = false, updatable = true, nullable = false)
	private int id;

	@Column(name = "rcp_name")
	private String name;

	@Column(name = "rcp_descript")
	private String description;

	@Column(name = "rcp_pic_url")
	private String picUrl;

	@Column(name = "rcp_ratings")
	private Integer ratings;

	@Column(name = "rcp_num_ratings")
	private Integer numRatings;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) // , mappedBy = "id.recipe")
	@JoinColumn(name = "rcp_id") // , table = "recipe_ingredients")
	private List<Ingredient> ingredients;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) // , mappedBy = "id.recipe")
	@JoinColumn(name = "rcp_id") // , table = "recipe_comments")
	private List<Comment> comments;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "rcp_id") // , table = "recipe_steps")
	private List<RecipeStep> steps;

	public RecipeFull() {
		super();
	}

	public RecipeFull(final RecipeJS recipe) {
		this.name = recipe.getName();
		this.description = recipe.getDescription();
		this.picUrl = recipe.getPicUrl();
		this.ratings = recipe.getRatings();
		this.numRatings = recipe.getNumRatings();
		this.steps = new ArrayList<>();
		this.comments = new ArrayList<>();
		this.ingredients = new ArrayList<>();

		// add recipe steps if not null (really should't be)
		final List<String> stepsFromJs = recipe.getSteps();

		if (stepsFromJs != null) {
			for (int i = 0; i < stepsFromJs.size(); ++i) {
				// create new recipe step object with a recipe step id object
				final RecipeStep thisStep = new RecipeStep();
				final RecipeStepId thisStepId = new RecipeStepId();

				// set the step no for the recipe step id
				thisStepId.setStepNo(i + 1);

				// add the instruction and recipe step id to this recipe step
				thisStep.setId(thisStepId);
				thisStep.setInst(stepsFromJs.get(i));

				// add this recipe step to this Recipe's steps
				this.steps.add(thisStep);
			}
		}

		// add ingredients if not null (really shouldn't be)
		final List<IngredientJS> ingsJs = recipe.getIngredients();

		if (ingsJs != null) {
			for (int i = 0; i < ingsJs.size(); ++i) {
				// get ingredient js object
				final IngredientJS thisIngJs = ingsJs.get(i);

				// create new ingredient and ingredient id object
				final Ingredient thisIng = new Ingredient();
				final IngredientId thisIngId = new IngredientId();

				// set the ingredient number for this ingredient id
				thisIngId.setIngNo(i + 1);

				// add the ingredient id to the new ingredient object
				thisIng.setId(thisIngId);

				// set the name and amount for this ingredient
				thisIng.setName(thisIngJs.getName());
				thisIng.setAmount(thisIngJs.getAmount());

				// add this ingredient to the list of ingredients
				this.ingredients.add(thisIng);
			}
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecipeFull other = (RecipeFull) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (ingredients == null) {
			if (other.ingredients != null)
				return false;
		} else if (!ingredients.equals(other.ingredients))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numRatings == null) {
			if (other.numRatings != null)
				return false;
		} else if (!numRatings.equals(other.numRatings))
			return false;
		if (picUrl == null) {
			if (other.picUrl != null)
				return false;
		} else if (!picUrl.equals(other.picUrl))
			return false;
		if (ratings == null) {
			if (other.ratings != null)
				return false;
		} else if (!ratings.equals(other.ratings))
			return false;
		if (steps == null) {
			if (other.steps != null)
				return false;
		} else if (!steps.equals(other.steps))
			return false;
		return true;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public String getDescription() {
		return description;
	}

	public int getId() {
		return id;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public String getName() {
		return name;
	}

	public Integer getNumRatings() {
		return numRatings;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public Integer getRatings() {
		return ratings;
	}

	public List<RecipeStep> getSteps() {
		return steps;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((ingredients == null) ? 0 : ingredients.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((numRatings == null) ? 0 : numRatings.hashCode());
		result = prime * result + ((picUrl == null) ? 0 : picUrl.hashCode());
		result = prime * result + ((ratings == null) ? 0 : ratings.hashCode());
		result = prime * result + ((steps == null) ? 0 : steps.hashCode());
		return result;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumRatings(int numratings) {
		this.numRatings = numratings;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

	public void setSteps(List<RecipeStep> steps) {
		this.steps = steps;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", description=" + description + ", picUrl=" + picUrl
				+ ", ratings=" + ratings + ", numRatings=" + numRatings + ", ingredients=" + ingredients + ", comments="
				+ comments + ", steps=" + steps + "]";
	}
}
