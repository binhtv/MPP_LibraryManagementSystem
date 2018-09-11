package group3.lms.business.entity;

import java.io.Serializable;

/**
 * 
 * @author binhtran
 *
 */
public class BookCopy implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2899569520830018307L;
	private int copyID;
	
	public BookCopy(int copy) {
		copyID = copy;
	}
	
	public int getCopyID() {
		return copyID;
	}
	
	public void setCopyID(int copyID) {
		this.copyID = copyID;
	}
}
