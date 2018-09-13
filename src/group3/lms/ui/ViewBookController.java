package group3.lms.ui;

import java.util.Optional;

import group3.lms.business.BookDao;
import group3.lms.business.MemberDao;
import group3.lms.business.PeriodicalDao;
import group3.lms.business.dto.PaperItemDTO;
import group3.lms.business.entity.PaperItem;
import group3.lms.business.entity.PaperItemCopy;
import group3.lms.business.entity.User;
import group3.lms.common.Common;
import group3.lms.common.Messages;
import group3.lms.dataaccess.DataAccess;
import group3.lms.dataaccess.impl.DataAccessFactory;
import group3.lms.ui.scene.SceneFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ViewBookController {
	@FXML
	private Button btnViewBook;
	@FXML
	private Button btnCancel;
	@FXML
	private TextField txtID;
	@FXML
	private TableView<PaperItemDTO> table;

	private final ObservableList<PaperItemDTO> data = FXCollections.observableArrayList();

	private MemberDao memberDao = new MemberDao();
	private BookDao bookDao = new BookDao();
	private PeriodicalDao periodicalDao = new PeriodicalDao();
	private DataAccess da = null;

	public ViewBookController() {
		// Read from the stored file
		da = DataAccessFactory.getDataAccess();
		da.read(memberDao);
		da.read(bookDao);
		da.read(periodicalDao);
	}

	@SuppressWarnings("unchecked")
	@FXML
	protected void initialize() {
		txtID.requestFocus();
		TableColumn<PaperItemDTO, String> isbnCol = new TableColumn<>(String.format("ISBN/ID"));
		isbnCol.setMinWidth(80);
		isbnCol.setCellValueFactory(new PropertyValueFactory<PaperItemDTO, String>("id"));
		isbnCol.setEditable(false);

		TableColumn<PaperItemDTO, String> titleCol = new TableColumn<>("Title");
		titleCol.setMinWidth(200);
		titleCol.setCellValueFactory(new PropertyValueFactory<PaperItemDTO, String>("title"));

		TableColumn<PaperItemDTO, String> copyIdCol = new TableColumn<>(String.format("Copy ID"));
		copyIdCol.setMinWidth(50);
		copyIdCol.setEditable(false);
		copyIdCol.setCellValueFactory(new PropertyValueFactory<PaperItemDTO, String>("copyId"));

		TableColumn<PaperItemDTO, String> typeColum = new TableColumn<>(String.format("Type"));
		typeColum.setMinWidth(100);
		typeColum.setEditable(false);
		typeColum.setCellValueFactory(new PropertyValueFactory<PaperItemDTO, String>("type"));
		
		TableColumn<PaperItemDTO, String> dueDateColumn = new TableColumn<>(String.format("Due Date"));
		dueDateColumn.setMinWidth(100);
		dueDateColumn.setEditable(false);
		dueDateColumn.setCellValueFactory(new PropertyValueFactory<PaperItemDTO, String>("dueDate"));
		
		TableColumn<PaperItemDTO, String> memberColumn = new TableColumn<>(String.format("Member"));
		memberColumn.setMinWidth(150);
		memberColumn.setEditable(false);
		memberColumn.setCellValueFactory(new PropertyValueFactory<PaperItemDTO, String>("member"));
		
		TableColumn<PaperItemDTO, String> dueColumn = new TableColumn<>(String.format("Is Due?"));
		dueColumn.setMinWidth(50);
		dueColumn.setEditable(false);
		dueColumn.setCellValueFactory(new PropertyValueFactory<PaperItemDTO, String>("due"));
		table.getColumns().addAll(isbnCol, titleCol, typeColum, copyIdCol, dueDateColumn, memberColumn, dueColumn);
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

	public void txtIdEnter(ActionEvent event) {
		viewBook();
	}
	
	public void clickViewBook(ActionEvent event) {
		viewBook();
	}

	private void viewBook() {
		if (txtID.getText() == null || txtID.getText().equals("")) {
			Common.showMessage(AlertType.INFORMATION, "BookID is not allowed empty!");
			txtID.requestFocus();
			return;
		}
		String id = txtID.getText().trim();
		PaperItem b = bookDao.getBookByISBN(id);
		if(b == null) {
			b = periodicalDao.getPeriodicalById(id);
		}
		
		if(b == null) {
			data.clear();
			Common.showMessage(AlertType.INFORMATION, "Book cannot be found!");
			txtID.requestFocus();
			return;
		}
		for(PaperItemCopy pic : b.getCopies()) {
			data.add(new PaperItemDTO(b, pic));
		}
		table.setItems(data);
	}
}
