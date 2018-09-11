package group3.lms.business.entity;

import java.io.Serializable;

/**
 * 
 * @author binhtran
 *
 */
public class PeriodicalCopy implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2899569520830018307L;
	private int copyID;
	
	public PeriodicalCopy(int copy) {
		copyID = copy;
	}
	
	public int getCopyID() {
		return copyID;
	}
	
	public void setCopyID(int copyID) {
		this.copyID = copyID;
	}
}
