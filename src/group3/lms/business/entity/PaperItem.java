package group3.lms.business.entity;

public abstract class PaperItem implements Borrowable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5527918550354145779L;
	
	protected String title;
	protected boolean available;
	protected int borrowDay;
}
