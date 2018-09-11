package group3.lms.business.entity;

import java.util.List;

/**
 * 
 * @author binhtran
 *
 */
public class Author extends Person {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4116465093723272480L;
	
	private String credential;
	private String shortBio;
	private Address address;
	private List<Book> books;
	
	public Author(String first, String last, String p, String credential, String shortBio) {
		super(first, last, p);
		this.credential = credential;
		this.shortBio = shortBio;
	}

	public String getCredential() {
		return credential;
	}

	public void setCredential(String credential) {
		this.credential = credential;
	}

	public String getShortBio() {
		return shortBio;
	}

	public void setShortBio(String shortBio) {
		this.shortBio = shortBio;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
