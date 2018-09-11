package group3.lms.ui;

import javax.swing.JOptionPane;

import group3.lms.business.UserDao;
import group3.lms.business.entity.User;
import group3.lms.common.Messages;
import group3.lms.dataaccess.DataAccess;
import group3.lms.dataaccess.impl.DataAccessFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginScreenController {
	@FXML
	private AnchorPane ap;
	@FXML
	private TextField txtName;
	@FXML
	private PasswordField txtPass;
	@FXML
	private Button btnLogin;

	public void txtNameEnter(ActionEvent event) {
		txtPass.requestFocus();
		return;
	}

	public void btnLoginClickMe(ActionEvent event) {
		if (txtName.getText() == null || txtName.getText().trim().equals("")) {
//		JOptionPane.showMessageDialog((Stage)ap.getScene().getWindow(), Messages.INPUT_USER_NAME.getValue());
			new Alert(AlertType.ERROR, Messages.INPUT_USER_NAME.getValue(), ButtonType.OK).show();
			txtName.requestFocus();
			return;
		}
		if (txtPass.getText() == null || txtPass.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, Messages.INPUT_PASSWORD.getValue());
			txtPass.requestFocus();
			return;
		}

		// Read from the stored file
		UserDao dao = new UserDao();
		DataAccess da = DataAccessFactory.getDataAccess();
		da.read(dao);
		User u = dao.getUser(txtName.getText());
		if (u == null || !txtPass.getText().equals(u.getPassword())) {
			JOptionPane.showMessageDialog(null, Messages.INCORRECT_USER_PASS.getValue());
			txtName.requestFocus();
		}
	}

}
