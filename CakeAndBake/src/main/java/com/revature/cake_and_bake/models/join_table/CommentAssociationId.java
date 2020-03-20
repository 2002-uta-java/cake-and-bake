package com.revature.cake_and_bake.models.join_table;

import java.io.Serializable;

public class CommentAssociationId implements Serializable {

	private static final long serialVersionUID = 1L;

	private int rcpId;
	private int commentNo;

	public CommentAssociationId() {
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
		CommentAssociationId other = (CommentAssociationId) obj;
		if (commentNo != other.commentNo)
			return false;
		if (rcpId != other.rcpId)
			return false;
		return true;
	}

	public int getCommentNo() {
		return commentNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + commentNo;
		result = prime * result + rcpId;
		return result;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public int getRcpId() {
		return rcpId;
	}

	public void setRcpId(int rcpId) {
		this.rcpId = rcpId;
	}

	@Override
	public String toString() {
		return "CommentAssociationId [recipeId=" + rcpId + ", commentNo=" + commentNo + "]";
	}
}
