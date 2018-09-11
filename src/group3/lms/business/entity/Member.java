package group3.lms.business.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author binhtran
 *
 */
public class Member extends Person {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7489588493170165965L;
	private String memberId;
	private Address address;
	private List<CheckoutRecord> records;

	public Member(String memberId, String first, String last, String p) {
		super(first, last, p);
		this.memberId = memberId;
		this.records = new ArrayList<>();
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public List<CheckoutRecord> getRecords() {
		return records;
	}

	public void addRecord(CheckoutRecord checkout) {
		this.records.add(checkout);
	}
}
