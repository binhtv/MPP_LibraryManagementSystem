package group3.lms.ui;

import group3.lms.common.Messages;
import group3.lms.ui.scene.SceneFactory;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainScreenController {
	@FXML
	AnchorPane rootContainer;
	@FXML
	private Button btnNewMem;
	@FXML
	private Button btnViewBk;
	@FXML
	private Button btnAddBkCopy;
	@FXML
	private Button btnCheckoutBk;

	@FXML
	protected void initialize() {
		MenuBar menuBar = new MenuBar();

		Menu menu = new Menu("Application");
		MenuItem printCheckOutMenu = new MenuItem();
		Label lblprintCheckOutMenu = new Label("Print Checkout Record");
		lblprintCheckOutMenu.setStyle("-fx-text-fill: blue;-fx-min-width:100;");
		printCheckOutMenu.setGraphic(lblprintCheckOutMenu);
		
		printCheckOutMenu.setOnAction(evt -> {
			Stage primaryStage = (Stage) rootContainer.getScene().getWindow();
			primaryStage.setTitle(Messages.TITLE_PRINT_CHECKOUT.getValue());
			primaryStage.setScene(SceneFactory.createViewCheckoutRecordScreen());
		});
		menu.getItems().add(printCheckOutMenu);
		
		MenuItem logoutMenu = new MenuItem();
		Label logout = new Label("Logout");
		logout.setStyle("-fx-text-fill: blue;-fx-min-width:100;");
		logoutMenu.setGraphic(logout);
		
		logoutMenu.setOnAction(evt -> {
			Stage primaryStage = (Stage) rootContainer.getScene().getWindow();
			primaryStage.setTitle(Messages.TITLE_LOGIN.getValue());
			primaryStage.setScene(SceneFactory.createLoginScreen());
			primaryStage.setUserData(null);
		});
		menu.getItems().add(logoutMenu);
		menu.getItems().add(new SeparatorMenuItem());
		MenuItem exitApp = new MenuItem();
		Label extLbl = new Label("Exit");
		extLbl.setStyle("-fx-text-fill: blue;-fx-min-width:100;");
		exitApp.setGraphic(extLbl);
		exitApp.setOnAction(evt -> Platform.exit());
		menu.getItems().add(exitApp);

		menuBar.getMenus().add(menu);

		VBox topContainer = new VBox();
		topContainer.setPrefWidth(1000);

		topContainer.getChildren().add(menuBar);
		rootContainer.getChildren().add(topContainer);
	}

	public void btnNewMemClickMe(ActionEvent event) {
		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		primaryStage.setScene(SceneFactory.createAddMemberScreen());
		primaryStage.setTitle(Messages.TITLE_ADD_NEW_MEMBER.getValue());
		setWindowToCenter(primaryStage);
	}

	public void btnViewBkClickMe(ActionEvent event) {
		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		primaryStage.setScene(SceneFactory.createViewBookScreen());
		primaryStage.setTitle(Messages.TITLE_VIEW_BOOK.getValue());
		setWindowToCenter(primaryStage);
	}

	public void btnAddBkCopyClickMe(ActionEvent event) {
		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		primaryStage.setScene(SceneFactory.createAddBookCopyScreen());
		primaryStage.setTitle(Messages.TITLE_ADD_BOOK_COPY.getValue());
		setWindowToCenter(primaryStage);
	}

	public void btnCheckoutBkClickMe(ActionEvent event) {
		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
