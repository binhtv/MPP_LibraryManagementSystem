package group3.lms.business.dto;

import java.time.LocalDate;

import group3.lms.business.entity.CheckoutEntry;
import group3.lms.business.entity.CheckoutRecord;
import group3.lms.business.entity.Member;
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
	
	public String getDueDate() {
		CheckoutEntry ce = pic.getCe();
		return ce == null ? "-" : ce.getDueDate().toString();
	}
	
	public String getMember() {
		CheckoutEntry ce = pic.getCe();
		if(ce != null) {
			CheckoutRecord cr = ce.getCheckoutRecord();
			if(cr != null) {
				Member m = cr.getMember();
				return m.getMemberId() + " # " + m.getFirstName() + " " + m.getLastName(); 
			}
		}
		
		return "-";
	}
	
	public String getDue() {
		CheckoutEntry ce = pic.getCe();
		if(ce != null) {
			if(ce.getDueDate().isAfter(LocalDate.now())) {
				return "NO";
			} else {
				return "YES";
			}
		}
		return "-";
	}
}
