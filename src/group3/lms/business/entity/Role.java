package group3.lms.business.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author binhtran
 *
 */
public abstract class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5252735951463234655L;
	public static final String ADD_MEMBER = "addMember";
	public static final String ADD_BOOKCOPY = "addBookCopy";
	public static final String CHECK_OUT = "checkOut";
	public static final String ADD_BOOK = "addBook";
	public static final String VIEW_BOOK = "viewBook";
	
	protected List<String> permissions;
	
	public boolean can(String permission) {
		return permissions != null && permissions.contains(permission);
	}
}
