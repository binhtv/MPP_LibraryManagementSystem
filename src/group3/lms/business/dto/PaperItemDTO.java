package group3.lms.business.dto;

import group3.lms.business.entity.PaperItem;
import group3.lms.business.entity.PaperItemCopy;

public class PaperItemDTO {
	private PaperItem pi;
	private PaperItemCopy pic;
	
	public PaperItemDTO(PaperItem pi, PaperItemCopy pic) {
		this.pi = pi;
		this.pic = pic;
	}
	
	public String getId() {
		return pi.getId();
	}
	
	public String getTitle() {
		return pi.getTitle();
	}
	
	public String getCopyId() {
		return String.valueOf(pic.getCopyID());
	}
	
	public String getBorrowDays() {
		return String.valueOf(pi.getBorrowDay());
	}
	
	public String getType() {
		return pi.getClass().getSimpleName();
	}

	public PaperItem getPi() {
		return pi;
	}
}
