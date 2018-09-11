package group3.lms.dataaccess.impl;

import group3.lms.dataaccess.DataAccess;

/**
 * 
 * @author binhtran
 *
 */
public class DataAccessFactory {
	public static DataAccess getDataAccess() {
		return new DataAccessSystem();
	}
}
