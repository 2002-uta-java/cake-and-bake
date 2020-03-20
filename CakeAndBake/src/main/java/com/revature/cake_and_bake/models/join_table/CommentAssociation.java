package com.revature.cake_and_bake.models.join_table;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "recipe_comments")
@IdClass(CommentAssociationId.class)
public class CommentAssociation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "rcp_id")
	private int rcpId;

	@Id
	@Column(name = "comment_no")
	private int commentNo;

	@Column(name = "comment_value")
	private String commentValue;

	@ManyToOne
	@JoinColumn(name = "rcp_id", insertable = false, updatable = false)
	private Recipe rcp;

	public CommentAssociation() {
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
		CommentAssociation other = (CommentAssociation) obj;
		if (commentNo != other.commentNo)
			return false;
		if (commentValue == null) {
			if (other.commentValue != null)
				return false;
		} else if (!commentValue.equals(other.commentValue))
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

	public int getCommentNo() {
		return commentNo;
	}

	public String getCommentValue() {
		return commentValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + commentNo;
		result = prime * result + ((commentValue == null) ? 0 : commentValue.hashCode());
		result = prime * result + ((rcp == null) ? 0 : rcp.hashCode());
		result = prime * result + rcpId;
		return result;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public void setCommentValue(String commentValue) {
		this.commentValue = commentValue;
	}

	@Override
	public String toString() {
		return "CommentAssociation [recipeId=" + rcpId + ", commentNo=" + commentNo + ", commentValue=" + commentValue
				+ ", recipe=" + (rcp != null ? rcp.getRcpId() : null) + "]";
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

}
