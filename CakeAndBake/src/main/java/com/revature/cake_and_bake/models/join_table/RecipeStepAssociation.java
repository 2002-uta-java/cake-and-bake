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
@Table(name = "recipe_steps")
@IdClass(RecipeStepAssociationId.class)
public class RecipeStepAssociation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "rcp_id")
	private int rcpId;

	@Id
	@Column(name = "rcp_step_no")
	private int stepNo;

	@Column(name = "rcp_step_inst")
	private String inst;

	@ManyToOne
	@JoinColumn(name = "rcp_id", insertable = false, updatable = false)
	private Recipe rcp;

	public RecipeStepAssociation() {
		super();
	}

	@Override
	public String toString() {
		return "RecipeStepAssociation [rcpId=" + rcpId + ", stepNo=" + stepNo + ", inst=" + inst + ", rcp="
				+ (rcp != null ? rcp.getRcpId() : null) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inst == null) ? 0 : inst.hashCode());
		result = prime * result + ((rcp == null) ? 0 : rcp.hashCode());
		result = prime * result + rcpId;
		result = prime * result + stepNo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecipeStepAssociation other = (RecipeStepAssociation) obj;
		if (inst == null) {
			if (other.inst != null)
				return false;
		} else if (!inst.equals(other.inst))
			return false;
		if (rcp == null) {
			if (other.rcp != null)
				return false;
		} else if (!rcp.equals(other.rcp))
			return false;
		if (rcpId != other.rcpId)
			return false;
		if (stepNo != other.stepNo)
			return false;
		return true;
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

	public void setStepNo(int stepNo) {
		this.stepNo = stepNo;
	}

	public String getInst() {
		return inst;
	}

	public void setInst(String inst) {
		this.inst = inst;
	}

	public Recipe getRcp() {
		return rcp;
	}

	public void setRcp(Recipe rcp) {
		this.rcp = rcp;
	}

}
