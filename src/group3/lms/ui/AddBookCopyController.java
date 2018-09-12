package group3.lms.ui;

import java.sql.SQLException;
import java.util.Optional;

import group3.lms.business.BookDao;
import group3.lms.business.UserDao;
import group3.lms.business.entity.Book;
import group3.lms.business.entity.BookCopy;
import group3.lms.business.entity.User;
import group3.lms.common.Common;
import group3.lms.common.Messages;
import group3.lms.dataaccess.DataAccess;
import group3.lms.dataaccess.impl.DataAccessFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class AddBookCopyController {
	@FXML
	private TextField txtISBN;
	@FXML
	private TextField txtNumOfCopy;
	@FXML
	private Button btnAdd;
	private BookDao dao = new BookDao();
	private DataAccess da = null;
	
	public AddBookCopyController() {
		// Read from the stored file
		da = DataAccessFactory.getDataAccess();
		da.read(dao);
	}
	

	public void txtISBNEnter(ActionEvent event) {	
		Book bk = checkExistISBN();
		if(bk == null)
			return;
		txtNumOfCopy.requestFocus();
	}

	public void btnAddClickMe(ActionEvent event) {	
		Book bk = checkExistISBN();
		if(bk == null)
			return;
		
		if (txtNumOfCopy.getText() == null || txtNumOfCopy.getText().trim().equals("")) {
			Common.showMessage(AlertType.ERROR, Messages.INPUT_NUM_OF_COPY.getValue());
			txtNumOfCopy.requestFocus();
			return;
		}

		// Read from the stored file
		for (int i = 1; i<= Integer.valueOf(txtNumOfCopy.getText()); i++) {
			bk.addCopy(new BookCopy(bk, i));
		}
		dao.updateBookCopy(bk);
		try {
			da.write(dao);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private Book checkExistISBN() {
		if (txtISBN.getText() == null || txtISBN.getText().trim().equals("")) {
			Common.showMessage(AlertType.ERROR, Messages.INPUT_ISBN.getValue());
			return null;
		} 
		
		Book u = dao.getBookByISBN(txtISBN.getText().toLowerCase());
		if (u == null) {
			Common.showMessage(AlertType.ERROR, Messages.NOT_EXIST_ISBN.getValue());
			txtISBN.requestFocus();
			return null;
		}
		
		return u;
	}

}
