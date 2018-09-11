package group3.lms.business.entity;

import java.util.List;

/**
 * 
 * @author binhtran
 *
 */
public class Book extends PaperItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5829148302241944202L;

	private String ISBN;
	private List<Author> authors;
	
	public String getISBN() {
		return ISBN;
	}
	
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
}
