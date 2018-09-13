package group3.lms.business.entity;

import java.io.Serializable;
import java.util.ArrayList;
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
	
	public CheckoutRecord(Member member) {
		this.member = member;
		this.member.addRecord(this);
		this.checkoutEntries = new ArrayList<>();
	}
	
	public Member getMember() {
		return member;
	}
	
	public void setMember(Member member) {
		this.member = member;
	}

	public List<CheckoutEntry> getCheckoutEntries() {
		return checkoutEntries;
	}

	public void addCheckoutEntry(CheckoutEntry entry) {
		this.checkoutEntries.add(entry);
	}
	
	@Override
	public String toString() {
		StringBuilder bd = new StringBuilder();
		bd.append("ID\t").append("Checkout Date\t").append("Due Date\t\t\t").append("Item\n");
		for(CheckoutEntry ce : checkoutEntries) {
			bd.append(ce).append("\n");
		}
		return bd.toString();
	}
}
