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

	public BookCopy(PaperItem paperItem, int copy) {
		super(paperItem, copy);
	}
	
	@Override
	public Book getPaperItem() {
		return (Book) this.paperItem;
	}
}
