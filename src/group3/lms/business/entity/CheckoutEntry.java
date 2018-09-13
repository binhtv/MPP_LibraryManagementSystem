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
	private CheckoutRecord cr;
	
	public CheckoutEntry(int id, LocalDate checkoutDate, PaperItemCopy bc, CheckoutRecord cr) throws Exception {
		if(bc == null || bc.getCe() != null) {
			throw new Exception("This item is not available.");
		}
		
		this.id = id;
		this.checkoutDate = checkoutDate;
		this.dueDate = checkoutDate.plusDays(bc.getPaperItem().getBorrowDay());
		this.paperItemCopy = bc;
		this.paperItemCopy.setCe(this);
		this.cr = cr;
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
	
	public CheckoutRecord getCheckoutRecord() {
		return this.cr;
	}
	
	@Override
	public String toString() {
		StringBuilder bd = new StringBuilder();
		bd.append(id).append("\t").append(checkoutDate).append("\t\t").append(dueDate).append("\t\t").append(paperItemCopy);
		return bd.toString();
	}
}
