package group3.lms.ui;

import java.util.Optional;

import group3.lms.business.UserDao;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginScreenController {
	@FXML
	private TextField txtName;
	@FXML
	private PasswordField txtPass;
	@FXML
	private Button btnLogin;
	
	public void txtNameEnter(ActionEvent event) {
		if (txtName.getText() == null || txtName.getText().trim().equals("")) {
			Optional<ButtonType> result =
					Common.showMessage(AlertType.CONFIRMATION, Messages.INPUT_USER_NAME.getValue());
			if (result.get() == ButtonType.OK) {
				Common.showMessage(AlertType.INFORMATION, "OK");
			} else {
				Common.showMessage(AlertType.INFORMATION, "NOT OK");
			}
			txtName.requestFocus();
			return;
		}
		txtPass.requestFocus();
	}

	public void btnLoginClickMe(ActionEvent event) {
		if (txtName.getText() == null || txtName.getText().trim().equals("")) {
			Common.showMessage(AlertType.ERROR, Messages.INPUT_USER_NAME.getValue());
			txtName.requestFocus();
			return;
		}
		if (txtPass.getText() == null || txtPass.getText().trim().equals("")) {
			Common.showMessage(AlertType.ERROR, Messages.INPUT_PASSWORD.getValue());
			txtPass.requestFocus();
			return;
		}

		UserDao dao = new UserDao();
		DataAccess da = DataAccessFactory.getDataAccess();
		da.read(dao);
		User u = dao.getUser(txtName.getText().toLowerCase());
		if (u == null || !txtPass.getText().equals(u.getPassword())) {
			Common.showMessage(AlertType.ERROR, Messages.INCORRECT_USER_PASS.getValue());
			txtName.requestFocus();
			return;
		}
		
		Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		primaryStage.setTitle(Messages.TITLE_MAIN_SCREEN.getValue());
		primaryStage.setScene(SceneFactory.createMainScreen(u.getRoles()));
		primaryStage.setUserData(u);
	}

}
