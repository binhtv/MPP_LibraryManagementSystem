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

	public Book(String ISBN, String title, int borrowDay) {
		super(title, borrowDay);
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
	
	@Override
	public void addCopy(PaperItemCopy copy) {
		this.copies.add((BookCopy)copy);
	}

	@Override
	public BookCopy getAvailableCopy() {
		for (BookCopy pi : copies) {
			if (pi.getCe() == null) {
				return pi;
			}
		}

		return null;
	}

	public void clearCopy() {
		this.copies = new ArrayList<>();
	}

	@Override
	public String getId() {
		return ISBN;
	}

	@Override
	public PaperItemCopy newCopy() {
		return new BookCopy(this, copies.size() + 1);
	}
}
