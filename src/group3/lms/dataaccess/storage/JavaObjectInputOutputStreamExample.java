package group3.lms.dataaccess.storage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import group3.lms.business.UserDao;
import group3.lms.business.entity.Librarian;
import group3.lms.business.entity.User;
import group3.lms.dataaccess.Dao;
import group3.lms.dataaccess.DataAccess;
import group3.lms.dataaccess.impl.DataAccessFactory;

public class JavaObjectInputOutputStreamExample {

	public static final String OUTPUT_DIR = System.getProperty("user.dir") + "/src/group3/lms/dataaccess/storage/users.txt";

	public static void main(String[] args) {
		Dao dao = new UserDao();
		DataAccess da = DataAccessFactory.getDataAccess();
		da.read(dao);
		List<User> list = (List<User>)dao.getAll();
		System.out.println(list);
		//display addresses
		System.exit(1);
		try {

			// Store Serialized User Object in File
			FileOutputStream fileOutputStream = new FileOutputStream(OUTPUT_DIR);
			List<User> users = new ArrayList<>();
			User user = new User("Binh", "Tran", "0938387272377", "binhtv", "3928#@$3$");
			user.addRole(new Librarian());
			users.add(user);
			ObjectOutputStream output = new ObjectOutputStream(fileOutputStream);
			output.writeObject(users);

			output.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

//		try {
//
//			// Read from the stored file
//			FileInputStream fileInputStream = new FileInputStream(new File(OUTPUT_DIR));
//			ObjectInputStream input = new ObjectInputStream(fileInputStream);
//			User user2 = (User) input.readObject();
//			System.out.println(user2.getFirstName() + "  " + user2.getLastName() + "  " + user2.getEmail());
//			input.close();
//
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
	}

}
