package com.revature.cake_and_bake.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "recipes")
public class Recipe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "recipes_rcp_id_seq", sequenceName = "recipes_rcp_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipes_rcp_id_seq")
	@Column(name = "rcp_id")
	private int id;

	@Column(name = "rcp_name")
	private String name;

	@Column(name = "rcp_descript")
	private String description;

	@OneToMany(mappedBy = "id.recipeId", fetch = FetchType.EAGER)
	private List<RecipeStep> steps;

	public Recipe() {
		super();
	}

	@Override
	public boolean equals(Object obj) {
		// just check whether or not the id's are the same
		if (obj instanceof Recipe)
			return this.id == ((Recipe) obj).id;
		// else return false
		return false;
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

	public List<RecipeStep> getSteps() {
		return steps;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((steps == null) ? 0 : steps.hashCode());
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

	public void setSteps(List<RecipeStep> steps) {
		this.steps = steps;
	}

	@Override
	public String toString() {
		String string = name;
		string += System.lineSeparator() + System.lineSeparator() + description;
		string += System.lineSeparator();

		for (final RecipeStep step : steps) {
			string += System.lineSeparator() + step.getId().getStepNo() + ") " + step.getInst();
		}
		return string;
	}
}
