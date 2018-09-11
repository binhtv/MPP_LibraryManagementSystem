package group3.lms.dataaccess;

import java.io.Serializable;
import java.util.List;

import group3.lms.business.entity.User;

/**
 * 
 * @author binhtran
 *
 */
public interface Dao {
	public String getName();
	
	public void unpackResultSet(Serializable rs);
	
	public List<?> getAll();
}
