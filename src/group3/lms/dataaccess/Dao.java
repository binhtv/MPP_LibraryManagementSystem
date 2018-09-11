package group3.lms.dataaccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 
 * @author binhtran
 *
 */
public interface Dao {
	public String getSql();
	public void unpackResultSet(ResultSet rs) throws SQLException;
	public List<?> getResults();
}
