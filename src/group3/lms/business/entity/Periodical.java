package group3.lms.business.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author binhtran
 *
 */
public class Periodical extends PaperItem {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3887290894636818639L;
	private String id;
	private List<PeriodicalCopy> copies;
	
	public Periodical(String id, String title,int borrowDay) {
		super(title, borrowDay);
		this.id = id;
		this.copies = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<PeriodicalCopy> getCopies() {
		return copies;
	}

	public void addCopy(PaperItemCopy copy) {
		this.copies.add((PeriodicalCopy)copy);
	}
	
	@Override
	public PeriodicalCopy getAvailableCopy() {
		for(PeriodicalCopy pi : copies) {
			if(pi.getCe() == null) {
				return pi;
			}
		}
		
		return null;
	}

	@Override
	public PaperItemCopy newCopy() {
		return new PeriodicalCopy(this, copies.size() + 1);
	}
}
