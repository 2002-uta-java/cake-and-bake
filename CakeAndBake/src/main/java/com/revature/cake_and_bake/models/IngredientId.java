package com.revature.cake_and_bake.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@Component
@Embeddable
public class IngredientId implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "rcp_id")
	private RecipeFull recipe;

	@Column(name = "ing_no")
	private int ingNo;

	public IngredientId() {
		super();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IngredientId other = (IngredientId) obj;
		if (ingNo != other.ingNo)
			return false;
		if (recipe == null) {
			if (other.recipe != null)
				return false;
		} else if (!recipe.equals(other.recipe))
			return false;
		return true;
	}

	public int getIngNo() {
		return ingNo;
	}

	public RecipeFull getRecipe() {
		return recipe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ingNo;
		result = prime * result + ((recipe == null) ? 0 : recipe.hashCode());
		return result;
	}

	public void setIngNo(int ingNo) {
		this.ingNo = ingNo;
	}

	public void setRecipe(RecipeFull recipe) {
		this.recipe = recipe;
	}

	@Override
	public String toString() {
		return "IngredientId [recipe=" + (recipe != null ? "" + recipe.getId() : "null") + ", ingNo=" + ingNo + "]";
	}

}
