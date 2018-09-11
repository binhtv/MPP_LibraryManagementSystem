package group3.lms.business.entity;

import java.io.Serializable;

/**
 * 
 * @author binhtran
 *
 */
public abstract class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4116465093723272480L;
	
	private String firstName;
	private String lastName;
	private String phone;
	
	public Person(String first, String last, String p) {
		firstName = first;
		lastName = last;
		phone = p;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
