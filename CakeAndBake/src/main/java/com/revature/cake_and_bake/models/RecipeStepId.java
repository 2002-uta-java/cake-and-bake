package com.revature.cake_and_bake.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.stereotype.Component;

@Component
@Embeddable
public class RecipeStepId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "rcp_id")
	private int recipeId;

	@Column(name = "rcp_step_no")
	private int stepNo;

	public RecipeStepId() {
		super();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RecipeStepId) {
			final RecipeStepId o2 = (RecipeStepId) obj;
			return this.recipeId == o2.recipeId && this.stepNo == o2.stepNo;
		}
		// else return false
		return false;
	}

	public int getRecipeId() {
		return recipeId;
	}

	public int getStepNo() {
		return stepNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + recipeId;
		result = prime * result + stepNo;
		return result;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public void setStepNo(int stepNo) {
		this.stepNo = stepNo;
	}

	@Override
	public String toString() {
		return "RecipeStepId [recipeId=" + recipeId + ", stepNo=" + stepNo + "]";
	}
}
