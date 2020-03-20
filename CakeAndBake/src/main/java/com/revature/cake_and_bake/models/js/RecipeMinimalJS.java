package com.revature.cake_and_bake.models.js;

import com.revature.cake_and_bake.models.RecipeMinimal;

public class RecipeMinimalJS {
	private int id;

	private String name;

	private String description;

	private String picUrl;

	private Integer ratings;

	private Integer numRatings;

	public RecipeMinimalJS() {
		super();
	}

	public RecipeMinimalJS(final RecipeMinimal recipe) {
		this.id = recipe.getId();
		this.name = recipe.getName();
		this.description = recipe.getDescription();
		this.picUrl = recipe.getPicUrl();
		this.ratings = recipe.getRatings();
		this.numRatings = recipe.getNumRatings();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecipeMinimalJS other = (RecipeMinimalJS) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
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
		if (id != other.id)
			return false;
		return true;
	}

	public String getDescription() {
		return description;
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

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((numRatings == null) ? 0 : numRatings.hashCode());
		result = prime * result + ((picUrl == null) ? 0 : picUrl.hashCode());
		result = prime * result + ((ratings == null) ? 0 : ratings.hashCode());
		result = prime * result + id;
		return result;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumRatings(Integer numRatings) {
		this.numRatings = numRatings;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public void setRatings(Integer ratings) {
		this.ratings = ratings;
	}

	public void setId(int rcpId) {
		this.id = rcpId;
	}

	@Override
	public String toString() {
		return "RecipeMinimalJS [rcpId=" + id + ", name=" + name + ", description=" + description + ", picUrl=" + picUrl
				+ ", ratings=" + ratings + ", numRatings=" + numRatings + "]";
	}
}
