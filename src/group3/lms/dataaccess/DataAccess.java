package group3.lms.dataaccess;

import java.sql.SQLException;

/**
 * 
 * @author binhtran
 *
 */
public interface DataAccess {
	void read(Dao dao);
	void write(Dao dao) throws SQLException;
	
}
