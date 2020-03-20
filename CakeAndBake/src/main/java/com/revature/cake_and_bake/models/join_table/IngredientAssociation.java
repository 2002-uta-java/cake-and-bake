package com.revature.cake_and_bake.models.join_table;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "recipe_ingredients")
@IdClass(IngredientAssociationId.class)
public class IngredientAssociation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "rcp_id")
	private int rcpId;

	@Id
	@Column(name = "ing_no")
	private int ingNo;

	@Column(name = "ing_name")
	private String name;

	@Column(name = "ing_amount")
	private String amount;

	@ManyToOne
	@JoinColumn(name = "rcp_id", insertable = false, updatable = false)
	private Recipe rcp;

	public IngredientAssociation() {
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
		IngredientAssociation other = (IngredientAssociation) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (ingNo != other.ingNo)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rcp == null) {
			if (other.rcp != null)
				return false;
		} else if (!rcp.equals(other.rcp))
			return false;
		if (rcpId != other.rcpId)
			return false;
		return true;
	}

	public String getAmount() {
		return amount;
	}

	public int getIngNo() {
		return ingNo;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ingNo;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((rcp == null) ? 0 : rcp.hashCode());
		result = prime * result + rcpId;
		return result;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public void setIngNo(int ingNo) {
		this.ingNo = ingNo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRcpId() {
		return rcpId;
	}

	public void setRcpId(int rcpId) {
		this.rcpId = rcpId;
	}

	public Recipe getRcp() {
		return rcp;
	}

	public void setRcp(Recipe rcp) {
		this.rcp = rcp;
	}

	@Override
	public String toString() {
		return "IngredientAssociation [recipeId=" + rcpId + ", ingNo=" + ingNo + ", name=" + name + ", amount=" + amount
				+ ", recipe=" + (rcp != null ? rcp.getRcpId() : null) + "]";
	}

}
