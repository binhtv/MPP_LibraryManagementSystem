package group3.lms.ui.scene;

import java.io.IOException;
import java.util.List;

import group3.lms.business.entity.Role;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public final class SceneFactory {
	private static final String LOGIN_SCREEN_FILE = "/group3/lms/ui/LoginScreen.fxml";
	private static final String MAIN_SCREEN_FILE = "/group3/lms/ui/MainScreen.fxml";
	private static final String ADD_MEMBER_SCREEN_FILE = "/group3/lms/ui/AddMemberScreen.fxml";
	private static final String CHECKOUTBOOK_SCREEN_FILE = "/group3/lms/ui/CheckoutBook.fxml";
	private static final String ADD_BOOK_COPY_SCREEN_FILE = "/group3/lms/ui/AddBookCopy.fxml";

	public static final Scene createLoginScreen() {
		Scene scene = null;
		try {
			Parent root = FXMLLoader.load(SceneFactory.class.getResource(LOGIN_SCREEN_FILE));
			scene = new Scene(root, 639, 316);
			scene.getStylesheets()
					.add(SceneFactory.class.getResource("/group3/lms/resources/application.css").toExternalForm());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return scene;
	}

	public static final Scene createMainScreen(List<Role> roles) {
		Scene scene = null;
		try {
			Parent root = FXMLLoader.load(SceneFactory.class.getResource(MAIN_SCREEN_FILE));
			scene = new Scene(root, 496, 295);
			for (Role r : roles) {
				if(!r.can(Role.ADD_BOOK)) {
					scene.lookup("#btnAddBk").setVisible(false);
				}
				if(!r.can(Role.ADD_BOOKCOPY)) {
					scene.lookup("#btnAddBkCopy").setVisible(false);
				}
				if(!r.can(Role.ADD_MEMBER)) {
					scene.lookup("#btnNewMem").setVisible(false);
				}
				if(!r.can(Role.CHECK_OUT)) {
					scene.lookup("#btnCheckoutBk").setVisible(false);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return scene;
	}

	public static final Scene createAddMemberScreen() {
		Scene scene = null;
		try {
			Parent root = FXMLLoader.load(SceneFactory.class.getResource(ADD_MEMBER_SCREEN_FILE));
			scene = new Scene(root, 780, 605);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return scene;
	} 
	
	public static final Scene createCheckoutScreen() {
		Scene scene = null;
		try {
			Parent root = FXMLLoader.load(SceneFactory.class.getResource(CHECKOUTBOOK_SCREEN_FILE));
			scene = new Scene(root, 512, 658);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return scene;
	}
	
	public static final Scene createAddBookCopyScreen() {
		Scene scene = null;
		try {
			Parent root = FXMLLoader.load(SceneFactory.class.getResource(ADD_BOOK_COPY_SCREEN_FILE));
			scene = new Scene(root, 435, 235);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return scene;
	}
}
