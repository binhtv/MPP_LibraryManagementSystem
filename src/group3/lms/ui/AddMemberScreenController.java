package group3.lms.ui;

import java.util.Optional;

import group3.lms.business.entity.User;
import group3.lms.common.Common;
import group3.lms.common.Messages;
import group3.lms.ui.scene.SceneFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class AddMemberScreenController {
	@FXML
	private Button btnNew;
	@FXML
	private Button btnSave;
	@FXML
	private Button btnCancel;
	@FXML
	private TextField txtMemberID;
	@FXML
	private TextField txtFName;
	@FXML
	private TextField txtLName;
	@FXML
	private TextField txtStreet;
	@FXML
	private TextField txtCity;
	@FXML
	private TextField txtState;
	@FXML
	private TextField txtZip;
	@FXML
	private TextField txtPhone;

	public void clickSave(ActionEvent event) {
		if (txtMemberID.getText() == null || txtMemberID.getText().equals("")) {
			Common.ShowMessage(AlertType.INFORMATION, "Member ID is not allowed empty!");
			txtMemberID.requestFocus();
		} else if (txtFName.getText() == null || txtFName.getText().equals("")) {
			Common.ShowMessage(AlertType.INFORMATION, "First Name is not allowed empty!");
			txtFName.requestFocus();
		} else if (txtLName.getText() == null || txtLName.getText().equals("")) {
			Common.ShowMessage(AlertType.INFORMATION, "Last Name is not allowed empty!");
			txtLName.requestFocus();
		} else if (txtStreet.getText() == null || txtStreet.getText().equals("")) {
			Common.ShowMessage(AlertType.INFORMATION, "Street is not allowed empty!");
			txtStreet.requestFocus();
		} else if (txtCity.getText() == null || txtCity.getText().equals("")) {
			Common.ShowMessage(AlertType.INFORMATION, "City is not allowed empty!");
			txtCity.requestFocus();
		} else if (txtState.getText() == null || txtState.getText().equals("")) {
			Common.ShowMessage(AlertType.INFORMATION, "State is not allowed empty!");
			txtState.requestFocus();
		} else if (txtZip.getText() == null || txtZip.getText().equals("")) {
			Common.ShowMessage(AlertType.INFORMATION, "Zip is not allowed empty!");
			txtZip.requestFocus();
		} else if (txtPhone.getText() == null || txtPhone.getText().equals("")) {
			Common.ShowMessage(AlertType.INFORMATION, "Phone is not allowed empty!");
			txtPhone.requestFocus();
		} else {
		}
	}

	public void clickNew(ActionEvent event) {
		Optional<ButtonType> result = Common.ShowMessage(AlertType.CONFIRMATION,
				Messages.INPUT_CREATENEWMEMBER.getValue());
		if (result.get() == ButtonType.OK) {
			txtMemberID.clear();
			txtFName.clear();
			txtLName.clear();
			txtStreet.clear();
			txtCity.clear();
			txtState.clear();
			txtZip.clear();
			txtPhone.clear();
			txtMemberID.requestFocus();
		}

	}
	
	public void clickCancel(ActionEvent event) {
		Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		primaryStage.setTitle(Messages.TITLE_MAIN_SCREEN.getValue());
		Object u = primaryStage.getUserData();
		if(u != null) {
			primaryStage.setScene(SceneFactory.createMainScreen(((User)u).getRoles()));
		} else {
			primaryStage.setScene(SceneFactory.createLoginScreen());
		}
	}
}
