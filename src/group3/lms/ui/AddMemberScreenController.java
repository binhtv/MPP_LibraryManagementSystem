package group3.lms.ui;

import java.util.Optional;

import group3.lms.business.MemberDao;
import group3.lms.business.entity.Address;
import group3.lms.business.entity.Member;
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
	private MemberDao dao = new MemberDao();
	private DataAccess da = null;

	public AddMemberScreenController() {
		// Read from the stored file
		da = DataAccessFactory.getDataAccess();
		da.read(dao);
	}

	@FXML
	protected void initialize() {
		txtMemberID.setText(dao.nextMemberId());
	}

	public void clickSave(ActionEvent event) {
		String textMemberId = txtMemberID.getText().trim();
		if (textMemberId == null || textMemberId.equals("")) {
			Common.showMessage(AlertType.INFORMATION, "Member ID is not allowed empty!");
			txtMemberID.requestFocus();
			return;
		}
		String textFName = txtFName.getText().trim();
		if (textFName == null || textFName.equals("")) {
			Common.showMessage(AlertType.INFORMATION, "First Name is not allowed empty!");
			txtFName.requestFocus();
			return;
		}
		String textLName = txtLName.getText().trim();
		if (textLName == null || textLName.equals("")) {
			Common.showMessage(AlertType.INFORMATION, "Last Name is not allowed empty!");
			txtLName.requestFocus();
			return;
		}
		String textStreet = txtStreet.getText().trim();
		if (textStreet == null || textStreet.equals("")) {
			Common.showMessage(AlertType.INFORMATION, "Street is not allowed empty!");
			txtStreet.requestFocus();
			return;
		}
		String textCity = txtCity.getText().trim();
		if (textCity == null || textCity.equals("")) {
			Common.showMessage(AlertType.INFORMATION, "City is not allowed empty!");
			txtCity.requestFocus();
			return;
		}
		String textState = txtState.getText().trim();
		if (textState == null || textState.equals("")) {
			Common.showMessage(AlertType.INFORMATION, "State is not allowed empty!");
			txtState.requestFocus();
			return;
		}
		String textZip = txtZip.getText().trim();
		if (textZip == null || textZip.equals("")) {
			Common.showMessage(AlertType.INFORMATION, "Zip is not allowed empty!");
			txtZip.requestFocus();
			return;
		}
		txtZip.setText(txtZip.getText().trim());
		if (checkNumber(txtZip.getText())) {
			txtZip.requestFocus();
			return;
		}
		String textPhone = txtPhone.getText().trim();
		if (textPhone == null || textPhone.equals("")) {
			Common.showMessage(AlertType.INFORMATION, "Phone is not allowed empty!");
			txtPhone.requestFocus();
			return;
		}
		txtPhone.setText(txtPhone.getText().trim());
		if (checkNumber(txtPhone.getText())) {
			txtPhone.requestFocus();
			return;
		}

		// Save new member
		Member newMember = new Member(dao.nextMemberId(), textFName, textLName, textPhone);
		Address address = new Address(textStreet, textCity, textState, textZip);
		newMember.setAddress(address);
		dao.addMember(newMember);
		try {
			if (da.write(dao)) {
				clearData();
				Common.showMessage(AlertType.INFORMATION, Messages.COMMON_SUCCESS_MESSAGE.getValue());
			} else {
				Common.showMessage(AlertType.ERROR, Messages.COMMON_INTERNAL_ERROR.getValue());
			}
		} catch (Exception e) {
			Common.showMessage(AlertType.ERROR, Messages.COMMON_INTERNAL_ERROR.getValue());
			e.printStackTrace();
		}
	}

	public void clickNew(ActionEvent event) {
		Optional<ButtonType> result = Common.showMessage(AlertType.CONFIRMATION,
				Messages.INPUT_CREATENEWMEMBER.getValue());
		if (result.get() == ButtonType.OK) {
			clearData();
		}

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

	private void clearData() {
		txtMemberID.setText(dao.nextMemberId());
		txtFName.clear();
		txtLName.clear();
		txtStreet.clear();
		txtCity.clear();
		txtState.clear();
		txtZip.clear();
		txtPhone.clear();
		txtFName.requestFocus();
	}

	private boolean checkNumber(String num) {
		boolean re = false;
		try {
			int number = Integer.parseInt(num);
			re = number <= 0;
		} catch (NumberFormatException ex) {
			re = true;
		}
		if (re)
			Common.showMessage(AlertType.INFORMATION, Messages.INPUT_NOT_NUMBER.getValue());

		return re;
	}
}
