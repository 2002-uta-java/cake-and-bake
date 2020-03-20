package com.revature.cake_and_bake.models.js;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.revature.cake_and_bake.models.Comment;
import com.revature.cake_and_bake.models.Ingredient;
import com.revature.cake_and_bake.models.RecipeFull;
import com.revature.cake_and_bake.models.RecipeStep;
import com.revature.cake_and_bake.models.join_table.CommentAssociation;
import com.revature.cake_and_bake.models.join_table.IngredientAssociation;
import com.revature.cake_and_bake.models.join_table.Recipe;
import com.revature.cake_and_bake.models.join_table.RecipeStepAssociation;

@Component
public class RecipeJS {
	private int id;
	private String name;
	private String description;
	private String picUrl;
	private Integer ratings;
	private Integer numRatings;

	private List<String> steps;
	private List<IngredientJS> ingredients;
	private List<String> comments;

	public RecipeJS() {
		super();
	}

	public RecipeJS(final Recipe recipe) {
		this.id = recipe.getRcpId();
		this.name = recipe.getName();
		this.description = recipe.getDescription();
		this.picUrl = recipe.getPicUrl();
		this.ratings = recipe.getRatings();
		this.numRatings = recipe.getNumRatings();

		// add steps if not null (shouldn't be)
		final List<RecipeStepAssociation> rcpSteps = recipe.getSteps();
		if (rcpSteps != null) {
			// create new array list with capacity needed
			this.steps = new ArrayList<>(rcpSteps.size());

			// the database MAY give the steps out of order, so make sure they go in in the
			// right order
			// sort rcpSteps by step number
			Collections.sort(rcpSteps, (r1, r2) -> Integer.compare(r1.getStepNo(), r2.getStepNo()));

			for (final RecipeStepAssociation rcpStep : rcpSteps) {
				// steps are 1-indexed so need to be converted to 0-indexed
				this.steps.add(rcpStep.getInst());
			}
		}

		// add ingredients if not null (shouldn't be)
		final List<IngredientAssociation> rcpIngs = recipe.getIngredients();
		if (rcpIngs != null) {
			// create new array list of given capacity
			this.ingredients = new ArrayList<>(rcpIngs.size());

			// order doesn't really matter, but might as well give it as it was entered
			Collections.sort(rcpIngs, (r1, r2) -> Integer.compare(r1.getIngNo(), r2.getIngNo()));

			for (final IngredientAssociation rcpIng : rcpIngs) {
				// create an ingredient js object
				final IngredientJS ingJs = new IngredientJS();
				ingJs.setName(rcpIng.getName());
				ingJs.setAmount(rcpIng.getAmount());

				this.ingredients.add(ingJs);
			}
		}

		// add comments if not null (they may be)
		final List<CommentAssociation> rcpComments = recipe.getComments();
		if (rcpComments != null) {
			// create new array list of needed capacity
			this.comments = new ArrayList<>(rcpComments.size());

			// give comments in order received in the database
			// sort comments
			Collections.sort(rcpComments, (r1, r2) -> Integer.compare(r1.getCommentNo(), r2.getCommentNo()));

			for (final CommentAssociation rcpComment : rcpComments) {
				this.comments.add(rcpComment.getCommentValue());
			}
		}
	}

	public RecipeJS(final RecipeFull recipe) {
		this.id = recipe.getId();
		this.name = recipe.getName();
		this.description = recipe.getDescription();
		this.picUrl = recipe.getPicUrl();
		this.ratings = recipe.getRatings();
		this.numRatings = recipe.getNumRatings();

		// add steps if not null (shouldn't be)
		final List<RecipeStep> rcpSteps = recipe.getSteps();
		if (rcpSteps != null) {
			// create new array list with capacity needed
			this.steps = new ArrayList<>(rcpSteps.size());

			// the database MAY give the steps out of order, so make sure they go in in the
			// right order
			// sort rcpSteps by step number
			Collections.sort(rcpSteps, (r1, r2) -> Integer.compare(r1.getId().getStepNo(), r2.getId().getStepNo()));

			for (final RecipeStep rcpStep : rcpSteps) {
				// steps are 1-indexed so need to be converted to 0-indexed
				this.steps.add(rcpStep.getInst());
			}
		}

		// add ingredients if not null (shouldn't be)
		final List<Ingredient> rcpIngs = recipe.getIngredients();
		if (rcpIngs != null) {
			// create new array list of given capacity
			this.ingredients = new ArrayList<>(rcpIngs.size());

			// order doesn't really matter, but might as well give it as it was entered
			Collections.sort(rcpIngs, (r1, r2) -> Integer.compare(r1.getId().getIngNo(), r2.getId().getIngNo()));

			for (final Ingredient rcpIng : rcpIngs) {
				// create an ingredient js object
				final IngredientJS ingJs = new IngredientJS();
				ingJs.setName(rcpIng.getName());
				ingJs.setAmount(rcpIng.getAmount());

				this.ingredients.add(ingJs);
			}
		}

		// add comments if not null (they may be)
		final List<Comment> rcpComments = recipe.getComments();
		if (rcpComments != null) {
			// create new array list of needed capacity
			this.comments = new ArrayList<>(rcpComments.size());

			// give comments in order received in the database
			// sort comments
			Collections.sort(rcpComments,
					(r1, r2) -> Integer.compare(r1.getId().getCommentNo(), r2.getId().getCommentNo()));

			for (final Comment rcpComment : rcpComments) {
				this.comments.add(rcpComment.getCommentValue());
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
		RecipeJS other = (RecipeJS) obj;
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

	public List<String> getComments() {
		return comments;
	}

	public String getDescription() {
		return description;
	}

	public int getId() {
		return id;
	}

	public List<IngredientJS> getIngredients() {
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

	public List<String> getSteps() {
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

	public void setComments(List<String> comments) {
		this.comments = comments;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIngredients(List<IngredientJS> ingredients) {
		this.ingredients = ingredients;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumRatings(int numRatings) {
		this.numRatings = numRatings;
	}

	public void setNumRatings(Integer numRatings) {
		this.numRatings = numRatings;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

	public void setRatings(Integer ratings) {
		this.ratings = ratings;
	}

	public void setSteps(List<String> steps) {
		this.steps = steps;
	}

	@Override
	public String toString() {
		return "RecipeJS [id=" + id + ", name=" + name + ", description=" + description + ", picUrl=" + picUrl
				+ ", ratings=" + ratings + ", numRatings=" + numRatings + ", steps=" + steps + ", ingredients="
				+ ingredients + ", comments=" + comments + "]";
	}

}
