package group3.lms.ui;

import group3.lms.common.Common;
import group3.lms.common.Messages;
import group3.lms.ui.scene.SceneFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class MainScreenController {
	@FXML
	private Button btnNewMem;
	@FXML
	private Button btnAddBk;
	@FXML
	private Button btnAddBkCopy;
	@FXML
	private Button btnCheckoutBk;

	public void btnNewMemClickMe(ActionEvent event) {
		Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		primaryStage.setTitle(Messages.TITLE_ADD_NEW_MEMBER.getValue());
		primaryStage.setScene(SceneFactory.createAddMemberScreen());
	}

	public void btnAddBkClickMe(ActionEvent event) {
		Common.ShowMessage(AlertType.INFORMATION, "add book");
	}

	public void btnAddBkCopyClickMe(ActionEvent event) {
		Common.ShowMessage(AlertType.INFORMATION, "add book copy");
	}

	public void btnCheckoutBkClickMe(ActionEvent event) {
		Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		primaryStage.setTitle(Messages.TITLE_ADD_CHECKOUT.getValue());
		primaryStage.setScene(SceneFactory.createCheckoutScreen());
	}

}
