package group3.lms.business.entity;

import java.io.Serializable;

/**
 * 
 * @author binhtran
 *
 */
public class Address implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5752364404359558627L;
	
	private String street, city, state, zip;

	public Address(String str, String c, String st, String z) {
		street = str;
		city = c;
		state = st;
		zip = z;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
}
