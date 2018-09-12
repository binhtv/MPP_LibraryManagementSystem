package group3.lms.common;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class Common {
	public static final String SYSTEM_NAME = "Library Management System";

	public static Optional<ButtonType> showMessage(AlertType type, String messge) {
		Alert alert = new Alert(type);
		alert.setTitle(SYSTEM_NAME);
		alert.setHeaderText(null);
		alert.setContentText(messge);

		return alert.showAndWait();
	}
}
