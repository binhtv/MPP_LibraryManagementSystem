package group3.lms.ui;

import java.util.Optional;

import group3.lms.business.MemberDao;
import group3.lms.business.entity.CheckoutRecord;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ViewCheckOutController {
	@FXML
	private TextField txtMemberId;
	@FXML
	private Button btnPrint;
	@FXML
	private Button btnCancel;
	@FXML
	private TextArea txtAreaOutput;
	
	private MemberDao dao = new MemberDao();
	private DataAccess da = null;

	public ViewCheckOutController() {
		// Read from the stored file
		da = DataAccessFactory.getDataAccess();
		da.read(dao);
	}

	public void txtMemberIdEnter(ActionEvent event) {
		printCheckoutRecord();
	}

	private void printCheckoutRecord() {
		String memberId = txtMemberId.getText().trim();
		if(memberId == null || "".equals(memberId)) {
			Common.showMessage(AlertType.INFORMATION, "Member ID is not allowed empty!");
			txtMemberId.requestFocus();
			return;
		}
		
		Member m = dao.getMember(memberId);
		if(m == null) {
			Common.showMessage(AlertType.INFORMATION, "Sorry, member cannot be found!");
			txtMemberId.requestFocus();
			return;
		}
		StringBuilder bd = new StringBuilder();
		bd.append(m).append("\n");
		int i = 1;
		for(CheckoutRecord rc : m.getRecords()) {
			bd.append("###Checkout ").append(i++).append("\n");
			bd.append(rc).append("\n");
		}
		
		txtAreaOutput.setText(bd.toString());
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

	public void btnAddClickPrint(ActionEvent event) {
		printCheckoutRecord();
	}
}
