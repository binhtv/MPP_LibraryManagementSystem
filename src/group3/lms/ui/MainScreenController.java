package group3.lms.ui;

import group3.lms.common.Common;
import group3.lms.common.Messages;
import group3.lms.ui.scene.SceneFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Screen;
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
		primaryStage.setScene(SceneFactory.createAddMemberScreen());
		primaryStage.setTitle(Messages.TITLE_ADD_NEW_MEMBER.getValue());
		setWindowToCenter(primaryStage);
	}

	public void btnAddBkClickMe(ActionEvent event) {
		Common.showMessage(AlertType.INFORMATION, "add book");
	}

	public void btnAddBkCopyClickMe(ActionEvent event) {
		Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(SceneFactory.createAddBookCopyScreen());
		primaryStage.setTitle(Messages.TITLE_ADD_BOOK_COPY.getValue());
		setWindowToCenter(primaryStage);
	}

	public void btnCheckoutBkClickMe(ActionEvent event) {
		Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(SceneFactory.createCheckoutScreen());
		primaryStage.setTitle(Messages.TITLE_ADD_CHECKOUT.getValue());
		setWindowToCenter(primaryStage);
	}
	
	private void setWindowToCenter(Stage primaryStage) {
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setX((primScreenBounds.getWidth() - primaryStage.getWidth()) / 2);
        primaryStage.setY((primScreenBounds.getHeight() - primaryStage.getHeight()) / 2);
	}

}
