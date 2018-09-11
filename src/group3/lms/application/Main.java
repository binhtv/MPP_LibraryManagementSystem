package group3.lms.application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
			Parent root =  FXMLLoader.load(getClass().getResource("/group3/lms/ui/LoginScreen.fxml"));
			Scene scene = new Scene(root,639,316);
			scene.getStylesheets().add(getClass().getResource("/group3/lms/resources/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
