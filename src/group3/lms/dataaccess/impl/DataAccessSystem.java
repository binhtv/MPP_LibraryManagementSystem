package group3.lms.dataaccess.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.sql.SQLException;

import group3.lms.dataaccess.Dao;
import group3.lms.dataaccess.DataAccess;

/**
 * 
 * @author binhtran
 *
 */
public class DataAccessSystem implements DataAccess {
	//package level access
	DataAccessSystem() {}
	public void read(Dao dao) {
		String fileName = dao.getName();
		ConnectManager con = new ConnectManager();
		dao.unpackResultSet((Serializable)con.getData(fileName));
	}
	
	public void write(Dao dao) throws SQLException {
		//same idea
	}
	
	
	
	public static class ConnectManager {
		private static final String OUTPUT_DIR = System.getProperty("user.dir") 
				+ "/src/group3/lms/dataaccess/storage/%.txt";
		
		public Object getData(String fileName) {
			Object data = null;
			try {
				//Read from the stored file
				FileInputStream fileInputStream = new FileInputStream(new File(
						OUTPUT_DIR.replace("%", fileName)));
				ObjectInputStream input = new ObjectInputStream(fileInputStream);
				data = input.readObject();
				input.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			return data;
		}
	}
}
