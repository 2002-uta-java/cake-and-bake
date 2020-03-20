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
@Table(name = "recipe_ingredients")
public class Ingredient implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private IngredientId id;

	@Column(name = "ing_name")
	private String name;

	@Column(name = "ing_amount")
	private String amount;

	public Ingredient() {
		super();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Ingredient) {
			if (this == obj)
				return true;
			final Ingredient i2 = (Ingredient) obj;
			return this.id.equals(i2.id);
		}

		return false;
	}

	public String getAmount() {
		return amount;
	}

	public IngredientId getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public void setId(IngredientId id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}




	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", ingredient=" + name + ", amount=" + amount + "]";
	}
}
