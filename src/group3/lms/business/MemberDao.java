package group3.lms.business;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import group3.lms.business.entity.CheckoutEntry;
import group3.lms.business.entity.CheckoutRecord;
import group3.lms.business.entity.Member;
import group3.lms.business.entity.PaperItem;
import group3.lms.dataaccess.Dao;

/**
 * 
 * @author binhtran
 *
 */
public class MemberDao implements Dao {
	private final static String TABLE_NAME = "members";
	private List<Member> members = new ArrayList<>();

	@Override
	public String getName() {
		return TABLE_NAME;
	}

	@Override
	public List<?> getAll() {
		return members;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void unpackData(Serializable rs) {
		this.members = (List<Member>) rs;
	}

	public void addMember(Member member) {
		this.members.add(member);
	}

	public Member getMember(String memberID) {
		for (Member m : members) {
			if (memberID.equalsIgnoreCase(m.getMemberId())) {
				return m;
			}
		}

		return null;
	}

	public void checkOut(Member m, List<PaperItem> pis) {
		CheckoutRecord cr = new CheckoutRecord(m);
		int i = 0;
		for (PaperItem pi : pis) {
			try {
				cr.addCheckoutEntry(new CheckoutEntry(++i, LocalDate.now(), pi.getAvailableCopy(), cr));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public String nextMemberId() {
		int nextId = members.size() + 1;
		return "M" + nextId;
	}
}
