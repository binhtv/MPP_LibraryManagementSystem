package group3.lms.application;

import group3.lms.common.Messages;
import group3.lms.ui.scene.SceneFactory;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 
 * @author binhtran
 *
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle(Messages.TITLE_LOGIN.getValue());
			primaryStage.setScene(SceneFactory.createLoginScreen());
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
