package group3.lms.ui;

import java.util.Optional;

import group3.lms.business.BookDao;
import group3.lms.business.PeriodicalDao;
import group3.lms.business.entity.Book;
import group3.lms.business.entity.PaperItem;
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
	private PeriodicalDao periodicalDao = new PeriodicalDao();
	private DataAccess da = null;

	public AddBookCopyController() {
		// Read from the stored file
		da = DataAccessFactory.getDataAccess();
		da.read(dao);
		da.read(periodicalDao);
	}

	public void txtISBNEnter(ActionEvent event) {
		PaperItem bk = checkExistISBN();
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

		PaperItem bk = checkInput();

		if (bk == null) {
			return;
		}

		for (int i = 1; i <= Integer.valueOf(txtNumOfCopy.getText()); i++) {
			bk.addCopy(bk.newCopy());
		}
		try {
			if (bk instanceof Book) {
				da.write(dao);
			} else {
				da.write(periodicalDao);
			}
			clearData();
			Common.showMessage(AlertType.INFORMATION, Messages.COMMON_SUCCESS_MESSAGE.getValue());
		} catch (Exception e) {
			e.printStackTrace();
			Common.showMessage(AlertType.ERROR, Messages.COMMON_INTERNAL_ERROR.getValue());
		}
	}

	private PaperItem checkInput() {
		PaperItem bk = checkExistISBN();
		if (bk == null)
			return null;

		if (txtNumOfCopy.getText() == null || txtNumOfCopy.getText().trim().equals("")) {
			Common.showMessage(AlertType.INFORMATION, Messages.INPUT_NUM_OF_COPY.getValue());
			txtNumOfCopy.requestFocus();
			return null;
		}
		txtNumOfCopy.setText(txtNumOfCopy.getText().trim());

		boolean isError = false;
		try {
			int num = Integer.parseInt(txtNumOfCopy.getText());
			isError = num <= 0;
		} catch (NumberFormatException ex) {
			isError = true;
		}
		if (isError) {
			Common.showMessage(AlertType.INFORMATION, Messages.INPUT_NOT_NUMBER.getValue());
			txtNumOfCopy.requestFocus();
			return null;
		}
		return bk;
	}

	private PaperItem checkExistISBN() {
		String id = txtISBN.getText().trim();
		if (txtISBN.getText() == null || id.equals("")) {
			Common.showMessage(AlertType.INFORMATION, Messages.INPUT_ISBN.getValue());
			return null;
		}
		txtISBN.setText(id);
		PaperItem u = dao.getBookByISBN(id);
		if (u == null) {
			u = periodicalDao.getPeriodicalById(id);
		}
		if (u == null) {
			Common.showMessage(AlertType.INFORMATION, Messages.NOT_EXIST_ISBN.getValue());
			txtISBN.requestFocus();
			return null;
		}

		return u;
	}

	private void clearData() {
		txtISBN.clear();
		txtNumOfCopy.clear();
	}

}
