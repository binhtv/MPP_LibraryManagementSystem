package group3.lms.business.entity;

import java.util.Arrays;

public class Administrator extends Role {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9131249383967717279L;

	public Administrator() {
		this.permissions = Arrays.asList(ADD_MEMBER, ADD_BOOK, VIEW_BOOK, ADD_BOOKCOPY);
	}
}
