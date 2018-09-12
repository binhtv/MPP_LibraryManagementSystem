package group3.lms.dataaccess;

/**
 * 
 * @author binhtran
 *
 */
public interface DataAccess {
	void read(Dao dao);
	boolean write(Dao dao);
	
}
