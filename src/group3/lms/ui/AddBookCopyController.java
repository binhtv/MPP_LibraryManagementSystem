package group3.lms.ui;

import java.util.Optional;

import group3.lms.business.BookDao;
import group3.lms.business.entity.Book;
import group3.lms.business.entity.BookCopy;
import group3.lms.business.entity.User;
import group3.lms.common.Common;
import group3.lms.common.Messages;
import group3.lms.dataaccess.DataAccess;
import group3.lms.dataaccess.impl.DataAccessFactory;
import group3.lms.ui.scene.SceneFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddBookCopyController {
	@FXML
	private TextField txtISBN;
	@FXML
	private TextField txtNumOfCopy;
	@FXML
	private Button btnAdd;
	@FXML
	private Button btnCancel;
	private BookDao dao = new BookDao();
	private DataAccess da = null;

	public AddBookCopyController() {
		// Read from the stored file
		da = DataAccessFactory.getDataAccess();
		da.read(dao);
	}

	public void txtISBNEnter(ActionEvent event) {
		Book bk = checkExistISBN();
		if (bk == null)
			return;
		txtNumOfCopy.requestFocus();
	}

	public void clickCancel(ActionEvent event) {
		Optional<ButtonType> result = Common.showMessage(AlertType.CONFIRMATION, Messages.NEW_MEMBER_CANCEL.getValue());
		if (result.get() == ButtonType.OK) {
			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.setTitle(Messages.TITLE_MAIN_SCREEN.getValue());
			Object u = primaryStage.getUserData();
			if (u != null) {
				primaryStage.setScene(SceneFactory.createMainScreen(((User) u).getRoles()));
			} else {
				primaryStage.setScene(SceneFactory.createLoginScreen());
			}
		}
	}

	public void btnAddClickMe(ActionEvent event) {

		Book bk = checkInput();

		if (bk == null)
			return;

		for (int i = 1; i <= Integer.valueOf(txtNumOfCopy.getText()); i++) {
			bk.addCopy(new BookCopy(bk, bk.getCopies().size() + 1));
		}
		try {
			da.write(dao);
			Common.showMessage(AlertType.INFORMATION, Messages.COMMON_SUCCESS_MESSAGE.getValue());
		} catch (Exception e) {
			e.printStackTrace();
			Common.showMessage(AlertType.ERROR, Messages.COMMON_INTERNAL_ERROR.getValue());
		}
	}

	private Book checkInput() {
		Book bk = checkExistISBN();
		if (bk == null)
			return null;

		if (txtNumOfCopy.getText() == null || txtNumOfCopy.getText().trim().equals("")) {
			Common.showMessage(AlertType.INFORMATION, Messages.INPUT_NUM_OF_COPY.getValue());
			txtNumOfCopy.requestFocus();
			return null;
		}
		txtNumOfCopy.setText(txtNumOfCopy.getText().trim());

		try {
			Integer.parseInt(txtNumOfCopy.getText());
		} catch (NumberFormatException ex) {
			Common.showMessage(AlertType.INFORMATION, Messages.INPUT_NOT_NUMBER.getValue());
			txtNumOfCopy.requestFocus();
			return null;
		}

		return bk;
	}

	private Book checkExistISBN() {
		if (txtISBN.getText() == null || txtISBN.getText().trim().equals("")) {
			Common.showMessage(AlertType.INFORMATION, Messages.INPUT_ISBN.getValue());
			return null;
		}
		txtISBN.setText(txtISBN.getText().trim());
		Book u = dao.getBookByISBN(txtISBN.getText().toLowerCase());
		if (u == null) {
			Common.showMessage(AlertType.INFORMATION, Messages.NOT_EXIST_ISBN.getValue());
			txtISBN.requestFocus();
			return null;
		}

		return u;
	}

}
