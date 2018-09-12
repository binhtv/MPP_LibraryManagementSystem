package group3.lms.business.entity;

import java.io.Serializable;

/**
 * 
 * @author binhtran
 *
 */
public abstract class PaperItemCopy implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2899569520830018307L;
	protected int copyID;
	private boolean temporaryLock;
	protected PaperItem paperItem;
	protected CheckoutEntry ce;

	public PaperItemCopy(PaperItem paperItem, int copy) {
		copyID = copy;
		this.paperItem = paperItem;
		this.ce = null;
		this.temporaryLock = false;
	}

	public int getCopyID() {
		return copyID;
	}

	public void setCopyID(int copyID) {
		this.copyID = copyID;
	}

	public abstract PaperItem getPaperItem();

	public CheckoutEntry getCe() {
		return ce;
	}

	public void setCe(CheckoutEntry ce) {
		this.ce = ce;
	}

	public boolean isLocked() {
		return temporaryLock;
	}

	public void lock() {
		this.temporaryLock = true;
	}
	
	public void unlock() {
		this.temporaryLock = false;
	}
}
