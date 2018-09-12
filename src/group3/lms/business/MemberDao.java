package group3.lms.business;

import java.io.Serializable;
import java.util.List;

import group3.lms.business.entity.Member;
import group3.lms.dataaccess.Dao;

/**
 * 
 * @author binhtran
 *
 */
public class MemberDao implements Dao {
	private final static String TABLE_NAME = "members";
	private List<Member> members;
	
	public Member getMember(String memberID) {
		for(Member m : members) {
			if(memberID.equals(m.getMemberId().toLowerCase())) {
				return m;
			}
		}
		
		return null;
	}
	
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
	public void unpackResultSet(Serializable rs) {
		this.members = (List<Member>) rs;
	}
}
