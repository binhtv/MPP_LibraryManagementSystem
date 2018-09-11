package group3.lms.business.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author binhtran
 *
 */
public class User extends Person {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7489588493170165965L;
	private String userName;
	private String password;
	private List<Role> roles;

	public User(String first, String last, String p, String userName, String password) {
		super(first, last, p);
		this.userName = userName;
		this.password = password;
		this.roles = new ArrayList<>();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void addRole(Role role) {
		this.roles.add(role);
	}
	
	@Override
	public String toString() {
		return this.userName;
	}
}
