package group3.lms.business;

import java.io.Serializable;
import java.util.List;

import group3.lms.business.entity.Book;
import group3.lms.business.entity.BookCopy;
import group3.lms.dataaccess.Dao;

/**
 * 
 * @author binhtran
 *
 */
public class BookDao extends PaperItemDao implements Dao {

	private final static String TABLE_NAME = "books";
	private List<Book> books;

	@Override
	public String getName() {
		return TABLE_NAME;
	}

	public Book getBookByISBN(String isbn) {
		for (Book u : books) {
			if (isbn.equals(u.getISBN().toLowerCase())) {
				return u;
			}
		}

		return null;
	}

	public void updateBookCopy(Book book) {
		for (Book u : books) {
			if (book.getISBN().equals(u.getISBN().toLowerCase())) {
				List<BookCopy> copies = u.getCopies();
				copies.clear();
				copies.addAll(book.getCopies());
				break;
			}
		}
	}
	
	@Override
	public List<?> getAll() {
		return books;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void unpackData(Serializable rs) {
		this.books = (List<Book>) rs;
	}
}
