package com.revature.cake_and_bake.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "recipe_steps")
public class RecipeStep implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RecipeStepId id;

	@Column(name = "rcp_step_inst")
	private String inst;

	public RecipeStep() {
		super();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RecipeStep) {
			return this.id.equals(((RecipeStep) obj).id);
		}
		// else return false
		return false;
	}

	public RecipeStepId getId() {
		return id;
	}

	public String getInst() {
		return inst;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((inst == null) ? 0 : inst.hashCode());
		return result;
	}

	public void setId(RecipeStepId id) {
		this.id = id;
	}

	public void setInst(String inst) {
		this.inst = inst;
	}




	@Override
	public String toString() {
		return "RecipeStep [id=" + id + ", inst=" + inst + "]";
	}
}
