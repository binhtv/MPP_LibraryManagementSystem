package group3.lms.ui;

import java.sql.SQLException;

import group3.lms.business.BookDao;
import group3.lms.business.entity.Book;
import group3.lms.business.entity.BookCopy;
import group3.lms.common.Common;
import group3.lms.common.Messages;
import group3.lms.dataaccess.DataAccess;
import group3.lms.dataaccess.impl.DataAccessFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

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
//		txtNumOfCopy.setOnKeyTyped(event ->{
//	        int maxCharacters = 5;
//	        if(txtNumOfCopy.getText().length() > maxCharacters) event.consume();
//	    });
	}

	public void txtISBNEnter(ActionEvent event) {
		Book bk = checkExistISBN();
		if (bk == null)
			return;
		txtNumOfCopy.requestFocus();
	}

	public void txtISBNOnKeyTyped(KeyEvent event) {
		int maxCharacters = 10;
//		txtISBN.setText(txtISBN.getText().trim());
		if (txtISBN.getText().length() > maxCharacters) {
			event.consume();
			return;
		}
		return;
	}

	public void txtNumCopOnKeyTyped(KeyEvent event) {
		int maxCharacters = 4;
//		txtNumOfCopy.setText(txtNumOfCopy.getText().trim());
		if (txtNumOfCopy.getText().length() > maxCharacters) {
			event.consume();
			return;
		}
		return;
	}

	public void btnAddClickMe(ActionEvent event) {

		Book bk = checkInput();

		if (bk == null)
			return;

		bk.clearCopy();
		for (int i = 1; i <= Integer.valueOf(txtNumOfCopy.getText()); i++) {
			bk.addCopy(new BookCopy(bk, i));
		}
		try {
			da.write(dao);
			Common.showMessage(AlertType.INFORMATION, Messages.COMMON_SUCCESS_MESSAGE.getValue());
		} catch (SQLException e) {
			e.printStackTrace();
			Common.showMessage(AlertType.ERROR, Messages.COMMON_INTERNAL_ERROR.getValue());
		}
	}

	private Book checkInput() {
		Book bk = checkExistISBN();
		if (bk == null)
			return null;

		if (txtNumOfCopy.getText() == null || txtNumOfCopy.getText().trim().equals("")) {
			Common.showMessage(AlertType.ERROR, Messages.INPUT_NUM_OF_COPY.getValue());
			txtNumOfCopy.requestFocus();
			return null;
		}
		txtNumOfCopy.setText(txtNumOfCopy.getText().trim());

		try {
			Integer.parseInt(txtNumOfCopy.getText());
		} catch (NumberFormatException ex) {
			Common.showMessage(AlertType.ERROR, Messages.INPUT_NOT_NUMBER.getValue());
			txtNumOfCopy.requestFocus();
			return null;
		}

		return bk;
	}

	private Book checkExistISBN() {
		if (txtISBN.getText() == null || txtISBN.getText().trim().equals("")) {
			Common.showMessage(AlertType.ERROR, Messages.INPUT_ISBN.getValue());
			return null;
		}
		txtISBN.setText(txtISBN.getText().trim());
		Book u = dao.getBookByISBN(txtISBN.getText().toLowerCase());
		if (u == null) {
			Common.showMessage(AlertType.ERROR, Messages.NOT_EXIST_ISBN.getValue());
			txtISBN.requestFocus();
			return null;
		}

		return u;
	}

}
