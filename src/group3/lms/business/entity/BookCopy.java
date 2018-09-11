package group3.lms.business.entity;

import java.io.Serializable;

/**
 * 
 * @author binhtran
 *
 */
public class BookCopy extends PaperItemCopy implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2899569520830018307L;
	
	public BookCopy(Book book, int copy) {
		super(book, copy);
	}

	@Override
	public Book getPaperItem() {
		return (Book) this.paperItem;
	}
}
