package com.revature.cake_and_bake.models.join_table;

import java.io.Serializable;

public class IngredientAssociationId implements Serializable {

	private static final long serialVersionUID = 1L;

	private int rcpId;
	private int ingNo;

	public IngredientAssociationId() {
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
		IngredientAssociationId other = (IngredientAssociationId) obj;
		if (ingNo != other.ingNo)
			return false;
		if (rcpId != other.rcpId)
			return false;
		return true;
	}

	public int getIngNo() {
		return ingNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ingNo;
		result = prime * result + rcpId;
		return result;
	}

	public void setIngNo(int ingNo) {
		this.ingNo = ingNo;
	}

	public int getRcpId() {
		return rcpId;
	}

	public void setRcpId(int rcpId) {
		this.rcpId = rcpId;
	}

	@Override
	public String toString() {
		return "IngredientAssociationId [recipeId=" + rcpId + ", ingNo=" + ingNo + "]";
	}
}
