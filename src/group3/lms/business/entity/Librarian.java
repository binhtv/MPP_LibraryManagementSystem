package group3.lms.business.entity;

import java.util.Arrays;

/**
 * 
 * @author binhtran
 *
 */
public class Librarian extends Role {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1645715155795193343L;

	public Librarian() {
		this.permissions = Arrays.asList(CHECK_OUT, VIEW_BOOK);
	}
}
