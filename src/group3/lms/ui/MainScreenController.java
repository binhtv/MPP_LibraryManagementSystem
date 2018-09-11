package group3.lms.ui;

import group3.lms.common.Common;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
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
		Common.ShowMessage(AlertType.INFORMATION, "New MEM");
	}

	public void btnAddBkClickMe(ActionEvent event) {
		Common.ShowMessage(AlertType.INFORMATION, "add book");
	}

	public void btnAddBkCopyClickMe(ActionEvent event) {
		Common.ShowMessage(AlertType.INFORMATION, "add book copy");
	}

	public void btnCheckoutBkClickMe(ActionEvent event) {
		Common.ShowMessage(AlertType.INFORMATION, "checkout book");
	}

}
