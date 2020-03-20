package com.revature.cake_and_bake.models.join_table;

import java.io.Serializable;

public class RecipeStepAssociationId implements Serializable {

	private static final long serialVersionUID = 1L;

	private int rcpId;
	private int stepNo;

	public RecipeStepAssociationId() {
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
		RecipeStepAssociationId other = (RecipeStepAssociationId) obj;
		if (rcpId != other.rcpId)
			return false;
		if (stepNo != other.stepNo)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rcpId;
		result = prime * result + stepNo;
		return result;
	}

	public int getRcpId() {
		return rcpId;
	}

	public void setRcpId(int rcpId) {
		this.rcpId = rcpId;
	}

	public int getStepNo() {
		return stepNo;
	}

	public void setRecipeId(int recipeId) {
		this.rcpId = recipeId;
	}

	public void setStepNo(int stepNo) {
		this.stepNo = stepNo;
	}

	@Override
	public String toString() {
		return "RecipeStepAssociationId [recipeId=" + rcpId + ", stepNo=" + stepNo + "]";
	}
}
