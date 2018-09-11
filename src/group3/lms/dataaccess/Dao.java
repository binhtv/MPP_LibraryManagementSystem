package group3.lms.dataaccess;

import java.io.Serializable;
import java.util.List;

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
