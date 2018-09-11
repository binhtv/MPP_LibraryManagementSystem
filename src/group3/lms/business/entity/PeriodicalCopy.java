package group3.lms.business.entity;

import java.io.Serializable;

/**
 * 
 * @author binhtran
 *
 */
public class PeriodicalCopy extends PaperItemCopy implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2899569520830018307L;
	
	public PeriodicalCopy(Periodical p, int copy) {
		super(p, copy);
	}

	@Override
	public Periodical getPaperItem() {
		return (Periodical) paperItem;
	}
}
