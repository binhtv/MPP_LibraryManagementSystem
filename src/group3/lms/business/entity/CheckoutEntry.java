package group3.lms.business.entity;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 
 * @author binhtran
 *
 */
public class CheckoutEntry implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3666709369033706395L;
	
	private int id;
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	private PaperItemCopy paperItemCopy;
	
	public CheckoutEntry(int id, LocalDate checkoutDate, PaperItemCopy bc) throws Exception {
		if(bc.getCe() != null) {
			throw new Exception("This item is borrowed.");
		}
		
		this.id = id;
		this.checkoutDate = checkoutDate;
		this.dueDate = checkoutDate.plusDays(bc.getPaperItem().getBorrowDay());
		this.paperItemCopy = bc;
		this.paperItemCopy.setCe(this);
	}
	
	public int getId() {
		return id;
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public PaperItemCopy getBookCopy() {
		return paperItemCopy;
	}
}
