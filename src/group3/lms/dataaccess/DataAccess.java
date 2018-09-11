package group3.lms.dataaccess;

import java.sql.SQLException;

/**
 * 
 * @author binhtran
 *
 */
public interface DataAccess {
	void read(Dao dao) throws SQLException;
	void write(Dao dao) throws SQLException;
	
}
