package group3.lms.dataaccess.storage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import group3.lms.business.entity.Address;
import group3.lms.business.entity.Administrator;
import group3.lms.business.entity.Author;
import group3.lms.business.entity.Book;
import group3.lms.business.entity.BookCopy;
import group3.lms.business.entity.CheckoutEntry;
import group3.lms.business.entity.CheckoutRecord;
import group3.lms.business.entity.Librarian;
import group3.lms.business.entity.Member;
import group3.lms.business.entity.Periodical;
import group3.lms.business.entity.PeriodicalCopy;
import group3.lms.business.entity.User;

public class DummyDataGenerator {

	public static final String USER_DIR = System.getProperty("user.dir")
			+ "/src/group3/lms/dataaccess/storage/users.txt";
	public static final String MEMBER_DIR = System.getProperty("user.dir")
			+ "/src/group3/lms/dataaccess/storage/members.txt";
	public static final String BOOK_DIR = System.getProperty("user.dir")
			+ "/src/group3/lms/dataaccess/storage/books.txt";
	public static final String PERIODICAL_DIR = System.getProperty("user.dir")
			+ "/src/group3/lms/dataaccess/storage/periodicals.txt";

	public static List<User> createUsers() {
		User u1 = new User("John", "Tran", "3938228383", "admin", "1234");
		u1.addRole(new Administrator());
		User u2 = new User("David", "Pham", "3938228383", "librarian", "1234");
		u2.addRole(new Librarian());
		List<User> users = new ArrayList<>();
		users.add(u1);
		users.add(u2);
		return users;
	}

	public static List<Member> createMembers(List<Book> books, List<Periodical> periodicals) throws Exception {
		Member m1 = new Member("M1", "Binh", "Tran", "094483283");
		m1.setAddress(new Address("1000 North 4th Street", "FairField", "Iowa", "52557"));
		CheckoutRecord cr = new CheckoutRecord(m1);
		cr.setMember(m1);
		Book book1 = books.get(0);
		Periodical p1 = periodicals.get(0);
		CheckoutEntry ce = new CheckoutEntry(1, LocalDate.of(2018, 9, 10), book1.getCopies().get(0), cr);
		cr.addCheckoutEntry(ce);
		CheckoutEntry ce1 = new CheckoutEntry(2, LocalDate.of(2018, 9, 10), p1.getCopies().get(0), cr);
		cr.addCheckoutEntry(ce1);

		Member m2 = new Member("M2", "Thao", "Dao", "094483283");
		m2.setAddress(new Address("1000 North 4th Street", "FairField", "Iowa", "52557"));
		CheckoutRecord cr1 = new CheckoutRecord(m2);
		Book book2 = books.get(1);
		Periodical p2 = periodicals.get(1);
		CheckoutEntry ce2 = new CheckoutEntry(3, LocalDate.of(2018, 9, 10), book2.getCopies().get(0), cr1);
		cr1.addCheckoutEntry(ce2);
		CheckoutEntry ce3 = new CheckoutEntry(4, LocalDate.of(2018, 9, 10), p2.getCopies().get(0), cr1);
		cr1.addCheckoutEntry(ce3);
		
		Member m3 = new Member("M3", "Nga", "Duy", "094483283");
		m3.setAddress(new Address("1000 North 4th Street", "FairField", "Iowa", "52557"));
		CheckoutRecord cr2 = new CheckoutRecord(m3);
		Book book3 = books.get(2);
		Periodical p3 = periodicals.get(2);
		CheckoutEntry ce4 = new CheckoutEntry(5, LocalDate.of(2018, 9, 10), book3.getCopies().get(0), cr2);
		cr2.addCheckoutEntry(ce4);
		CheckoutEntry ce5 = new CheckoutEntry(6, LocalDate.of(2018, 9, 10), p3.getCopies().get(0), cr2);
		cr2.addCheckoutEntry(ce5);
		
		Member m4 = new Member("M4", "Thanh", "Tran", "094483283");
		m4.setAddress(new Address("1000 North 4th Street", "FairField", "Iowa", "52557"));
		CheckoutRecord cr3 = new CheckoutRecord(m4);
		Book book4 = books.get(3);
		Periodical p4 = periodicals.get(2);
		CheckoutEntry ce6 = new CheckoutEntry(7, LocalDate.of(2018, 9, 10), book4.getCopies().get(0), cr3);
		cr3.addCheckoutEntry(ce6);
		CheckoutEntry ce7 = new CheckoutEntry(8, LocalDate.of(2018, 9, 10), p4.getCopies().get(1), cr3);
		cr3.addCheckoutEntry(ce7);
		
		List<Member> list = new ArrayList<>();
		list.add(m1);
		list.add(m2);
		list.add(m3);
		list.add(m4);
		return list;
	}

	public static List<Book> createBooks() {
		Book b1 = new Book("BOOK1", "Java Programing", 21);
		Author author = new Author("John", "Lerm", "38283923", "Java Sun Sertificate",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
		Author author1 = new Author("KHE", "MEME", "38283923", "J#",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
		b1.addAuthor(author);
		b1.addAuthor(author1);
		BookCopy copy1 = new BookCopy(b1, 1);
		BookCopy copy2 = new BookCopy(b1, 2);
		BookCopy copy3 = new BookCopy(b1, 3);
		b1.addCopy(copy1);
		b1.addCopy(copy2);
		b1.addCopy(copy3);

		Book b2 = new Book("BOOK2", "C++ Programing", 21);
		Author author2 = new Author("John", "Lerm", "38283923", "C++",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
		b2.addAuthor(author2);
		BookCopy copy4 = new BookCopy(b2, 1);
		BookCopy copy5 = new BookCopy(b2, 2);
		BookCopy copy6 = new BookCopy(b2, 3);
		b2.addCopy(copy4);
		b2.addCopy(copy5);
		b2.addCopy(copy6);

		Book b3 = new Book("BOOK3", "C# Programing", 7);
		Author author3 = new Author("Author 3", "Jla", "38283923", "C#",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
		b3.addAuthor(author3);
		BookCopy copy7 = new BookCopy(b3, 1);
		b3.addCopy(copy7);

		Book b4 = new Book("BOOK4", "PHP Programing", 7);
		Author author4 = new Author("Author 4", "Lerm", "38283923", "PHP",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
		b4.addAuthor(author4);
		BookCopy copy8 = new BookCopy(b4, 1);
		b4.addCopy(copy8);

		List<Book> list = new ArrayList<>();
		list.add(b1);
		list.add(b2);
		list.add(b3);
		list.add(b4);
		return list;
	}

	public static List<Periodical> createPeriodicals() {
		Periodical b1 = new Periodical("P1", "New york time", 21);
		PeriodicalCopy copy1 = new PeriodicalCopy(b1, 1);
		PeriodicalCopy copy2 = new PeriodicalCopy(b1, 2);
		b1.addCopy(copy1);
		b1.addCopy(copy2);

		Periodical b2 = new Periodical("P2", "Guradian", 21);
		PeriodicalCopy copy3 = new PeriodicalCopy(b2, 1);
		PeriodicalCopy copy4 = new PeriodicalCopy(b2, 2);
		b2.addCopy(copy3);
		b2.addCopy(copy4);

		Periodical b3 = new Periodical("P3", "VnExpress", 7);
		PeriodicalCopy copy5 = new PeriodicalCopy(b3, 1);
		PeriodicalCopy copy6 = new PeriodicalCopy(b3, 2);
		b3.addCopy(copy5);
		b3.addCopy(copy6);

		Periodical b4 = new Periodical("P4", "Tuoi Tre", 7);
		PeriodicalCopy copy7 = new PeriodicalCopy(b4, 1);
		PeriodicalCopy copy8 = new PeriodicalCopy(b4, 2);
		b3.addCopy(copy7);
		b3.addCopy(copy8);

		List<Periodical> list = new ArrayList<>();
		list.add(b1);
		list.add(b2);
		list.add(b3);
		list.add(b4);
		return list;
	}

	public static void main(String[] args) {
		// Dao dao = new UserDao();
		// DataAccess da = DataAccessFactory.getDataAccess();
		// da.read(dao);
		// List<User> list = (List<User>)dao.getAll();
		// System.out.println(list);
		// display addresses
		// System.exit(1);
		try {

			// Store Serialized User Object in File
			FileOutputStream fosUser = new FileOutputStream(USER_DIR);
			List<User> users = createUsers();
			ObjectOutputStream outputUser = new ObjectOutputStream(fosUser);
			outputUser.writeObject(users);
			outputUser.close();
			
			
			
			List<Book> books = createBooks();
			List<Periodical> periodicals = createPeriodicals();
			
			FileOutputStream fosMembers = new FileOutputStream(MEMBER_DIR);
			List<Member> members = createMembers(books, periodicals);
			ObjectOutputStream outputMember = new ObjectOutputStream(fosMembers);
			outputMember.writeObject(members);
			outputMember.close();
			
			FileOutputStream fosBook = new FileOutputStream(BOOK_DIR);
			ObjectOutputStream outputBook = new ObjectOutputStream(fosBook);
			outputBook.writeObject(books);
			outputBook.close();
			
			FileOutputStream fosPeriodical = new FileOutputStream(PERIODICAL_DIR);
			ObjectOutputStream outputPeriodical = new ObjectOutputStream(fosPeriodical);
			outputPeriodical.writeObject(periodicals);
			outputPeriodical.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}

		// try {
		//
		// // Read from the stored file
		// FileInputStream fileInputStream = new FileInputStream(new
		// File(OUTPUT_DIR));
		// ObjectInputStream input = new ObjectInputStream(fileInputStream);
		// User user2 = (User) input.readObject();
		// System.out.println(user2.getFirstName() + " " + user2.getLastName() +
		// " " + user2.getEmail());
		// input.close();
		//
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// } catch (ClassNotFoundException e) {
		// e.printStackTrace();
		// }
	}

}
