package com.revature.cake_and_bake.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * This is a minimal class for recipes which <em>only</em> holds the data
 * actually held in the table for recipes. This must be used to insert a new
 * recipe into the database so that we can get the primary key for the recipe to
 * be inserted into the database.
 * 
 * @author bennattj
 *
 */
@Entity
@Component
@Table(name = "recipes")
public class RecipeMinimal implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "recipes_rcp_id_seq", sequenceName = "recipes_rcp_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipes_rcp_id_seq")
	@Column(name = "rcp_id", insertable = true, updatable = false, nullable = false)
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

	public RecipeMinimal() {
		super();
	}

	public RecipeMinimal(final RecipeFull recipe) {
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
		RecipeMinimal other = (RecipeMinimal) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
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
		return true;
	}

	public String getDescription() {
		return description;
	}

	public int getId() {
		return id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((numRatings == null) ? 0 : numRatings.hashCode());
		result = prime * result + ((picUrl == null) ? 0 : picUrl.hashCode());
		result = prime * result + ((ratings == null) ? 0 : ratings.hashCode());
		return result;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "RecipeMinimal [id=" + id + ", name=" + name + ", description=" + description + ", picUrl=" + picUrl
				+ ", ratings=" + ratings + ", numRatings=" + numRatings + "]";
	}

}
