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
@Table(name = "recipe_comments")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CommentId id;

	@Column(name = "comment_value")
	private String commentValue;

	public Comment() {
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
		Comment other = (Comment) obj;
		if (commentValue == null) {
			if (other.commentValue != null)
				return false;
		} else if (!commentValue.equals(other.commentValue))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getCommentValue() {
		return commentValue;
	}

	public CommentId getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commentValue == null) ? 0 : commentValue.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public void setCommentValue(String commentValue) {
		this.commentValue = commentValue;
	}




	public void setId(CommentId id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", com=" + commentValue + "]";
	}

}
