package group3.lms.ui;

import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JOptionPane;

import group3.lms.business.entity.User;
import group3.lms.common.Messages;
import group3.lms.dataaccess.storage.JavaObjectInputOutputStreamExample;
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
	
public void btnLoginClickMe(ActionEvent event) {
	txtName.setText("binhtv");
	txtPass.setText("3928#@$3$");
	if(txtName.getText() == null || txtName.getText().trim().equals("")) {
//		JOptionPane.showMessageDialog((Stage)ap.getScene().getWindow(), Messages.INPUT_USER_NAME.getValue());
		new Alert(AlertType.ERROR,Messages.INPUT_USER_NAME.getValue(),ButtonType.OK).show();
		txtName.requestFocus();
		return;
	}
	if(txtPass.getText() == null || txtPass.getText().trim().equals("")) {
		JOptionPane.showMessageDialog( null, Messages.INPUT_PASSWORD.getValue());
		txtPass.requestFocus();
		return;
	}
	try {

		//Read from the stored file
		FileInputStream fileInputStream = new FileInputStream(new File(
				JavaObjectInputOutputStreamExample.OUTPUT_DIR));
		ObjectInputStream input = new ObjectInputStream(fileInputStream);
		List<User> user2 = (List<User>) input.readObject();
		input.close();
		for (User u: user2) {
			if (u.getUserName().equals(txtName.getText())
				&& u.getPassword().equals(txtPass.getText())) {
				return;
			}			
		}
		JOptionPane.showMessageDialog(null, Messages.INCORRECT_USER_PASS.getValue());
		txtName.requestFocus();

	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	}

}
