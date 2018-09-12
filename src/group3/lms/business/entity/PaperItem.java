package group3.lms.business.entity;

import java.util.List;

public abstract class PaperItem implements Borrowable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5527918550354145779L;
	
	private String title;
	private int borrowDay;
	
	public PaperItem(String title, int borrowDay) {
		this.title = title;
		this.borrowDay = borrowDay;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getBorrowDay() {
		return borrowDay;
	}

	public void setBorrowDay(int borrowDay) {
		this.borrowDay = borrowDay;
	}
	
	public abstract List<? extends PaperItemCopy> getCopies();
	public abstract PaperItemCopy getAvailableCopy();
	public abstract String getId();
	public abstract void addCopy(PaperItemCopy copy);
	public abstract PaperItemCopy newCopy();
	@Override
	public String toString() {
		return getId() + "#" + title;
	}
}
