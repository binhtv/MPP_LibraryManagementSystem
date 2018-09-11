package group3.lms.business.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author binhtran
 *
 */
public class CheckoutRecord implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 574053768167150634L;
	private Member member;
	private List<CheckoutEntry> checkoutEntries;
	
	public Member getMember() {
		return member;
	}
	
	public void setMember(Member member) {
		this.member = member;
	}

	public List<CheckoutEntry> getCheckoutEntries() {
		return checkoutEntries;
	}

	public void setCheckoutEntries(List<CheckoutEntry> checkoutEntries) {
		this.checkoutEntries = checkoutEntries;
	}
}
