package com.revature.cake_and_bake.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@Component
@Embeddable
public class CommentId implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "rcp_id")
	private RecipeFull recipe;

	@Column(name = "comment_no")
	private int commentNo;

	public CommentId() {
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
		CommentId other = (CommentId) obj;
		if (commentNo != other.commentNo)
			return false;
		if (recipe == null) {
			if (other.recipe != null)
				return false;
		} else if (!recipe.equals(other.recipe))
			return false;
		return true;
	}

	public int getCommentNo() {
		return commentNo;
	}

	public RecipeFull getRecipe() {
		return recipe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + commentNo;
		result = prime * result + ((recipe == null) ? 0 : recipe.hashCode());
		return result;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public void setRecipe(RecipeFull recipe) {
		this.recipe = recipe;
	}

	@Override
	public String toString() {
		return "CommentId [recipe=" + (recipe != null ? "" + recipe.getId() : "null") + ", commentNo=" + commentNo
				+ "]";
	}

}
