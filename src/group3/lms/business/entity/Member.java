package group3.lms.business.entity;

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

	public Member(String first, String last, String p) {
		super(first, last, p);
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
}
