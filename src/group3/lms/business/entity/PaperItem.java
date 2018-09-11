package group3.lms.business.entity;

public abstract class PaperItem implements Borrowable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5527918550354145779L;
	
	private String title;
	private boolean available;
	private int borrowDay;
	
	public PaperItem(String title, boolean available, int borrowDay) {
		this.setTitle(title);
		this.setAvailable(available);
		this.setBorrowDay(borrowDay);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public int getBorrowDay() {
		return borrowDay;
	}

	public void setBorrowDay(int borrowDay) {
		this.borrowDay = borrowDay;
	}
}
