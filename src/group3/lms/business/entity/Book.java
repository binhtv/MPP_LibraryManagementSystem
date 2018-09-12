package group3.lms.business.entity;

import java.util.ArrayList;
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
	private List<BookCopy> copies;

	public Book(String ISBN, String title, boolean available, int borrowDay) {
		super(title, available, borrowDay);
		this.ISBN = ISBN;
		this.authors = new ArrayList<>();
		this.copies = new ArrayList<>();
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void addAuthor(Author author) {
		this.authors.add(author);
	}

	public List<BookCopy> getCopies() {
		return copies;
	}

	public void addCopy(BookCopy copy) {
		this.copies.add(copy);
	}

	public void clearCopy() {
		this.copies = new ArrayList<>();
	}
}
