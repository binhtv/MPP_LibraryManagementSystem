package group3.lms.business;

import java.io.Serializable;
import java.util.List;

import group3.lms.business.entity.User;
import group3.lms.dataaccess.Dao;

/**
 * 
 * @author binhtran
 *
 */
public class UserDao implements Dao {
	private final static String TABLE_NAME = "users";
	private List<User> users;
	
	@Override
	public String getName() {
		return TABLE_NAME;
	}
	
	@Override
	public List<?> getAll() {
		return users;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void unpackResultSet(Serializable rs) {
		this.users = (List<User>) rs;
	}
}
