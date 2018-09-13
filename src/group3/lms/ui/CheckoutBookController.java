package group3.lms.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import group3.lms.business.BookDao;
import group3.lms.business.MemberDao;
import group3.lms.business.PeriodicalDao;
import group3.lms.business.dto.PaperItemDTO;
import group3.lms.business.entity.Book;
import group3.lms.business.entity.Member;
import group3.lms.business.entity.PaperItem;
import group3.lms.business.entity.Periodical;
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

public class CheckoutBookController {
	@FXML
	private Button btnCheckout;
	@FXML
	private Button btnAdd;
	@FXML
	private Button btnCancel;
	@FXML
	private TextField txtMemberID;
	@FXML
	private TextField txtID;
	@FXML
	private TableView<PaperItemDTO> table;

	private final ObservableList<PaperItemDTO> data = FXCollections.observableArrayList();

	private MemberDao memberDao = new MemberDao();
	private BookDao bookDao = new BookDao();
	private PeriodicalDao periodicalDao = new PeriodicalDao();
	private DataAccess da = null;

	public CheckoutBookController() {
		// Read from the stored file
		da = DataAccessFactory.getDataAccess();
		da.read(memberDao);
		da.read(bookDao);
		da.read(periodicalDao);
	}

	@SuppressWarnings("unchecked")
	@FXML
	protected void initialize() {
		txtMemberID.requestFocus();
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

		table.getColumns().addAll(isbnCol, titleCol, typeColum, copyIdCol);
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

	public void addItem(ActionEvent event) {
		if (txtMemberID.getText() == null || txtMemberID.getText().equals("")) {
			Common.showMessage(AlertType.INFORMATION, "Member ID is not allowed empty!");
			txtMemberID.requestFocus();
			return;
		}
		if (txtID.getText() == null || txtID.getText().equals("")) {
			Common.showMessage(AlertType.INFORMATION, "Book ISBN/ID is not allowed empty!");
			txtID.requestFocus();
			return;
		}

		Member m = memberDao.getMember(txtMemberID.getText());
		if (m == null) {
			Common.showMessage(AlertType.INFORMATION, Messages.NOT_EXIST_MEMBERID.getValue());
			txtMemberID.requestFocus();
			return;
		}

		// get Book from stored file
		Book b = bookDao.getBookByISBN(txtID.getText());
		Periodical p = null;
		if (b == null) {
			p = periodicalDao.getPeriodicalById(txtID.getText());
		}

		if (b == null && p == null) {
			Common.showMessage(AlertType.INFORMATION, Messages.NOT_EXIST_ISBN.getValue());
			txtID.requestFocus();
			return;
		}

		if (b != null && !bookDao.isAvailable(b)) {
			Common.showMessage(AlertType.INFORMATION, Messages.NOT_AVAILABLE_COPYBOOK.getValue());
			txtID.requestFocus();
			return;
		}

		if (p != null && !periodicalDao.isAvailable(p)) {
			Common.showMessage(AlertType.INFORMATION, Messages.NOT_AVAILABLE_COPYBOOK.getValue());
			txtID.requestFocus();
			return;
		}

		if (b != null) {
			if (!bookExists(b)) {
				data.add(new PaperItemDTO(b, b.getAvailableCopy()));
				table.setItems(data);
			} else {
				Common.showMessage(AlertType.INFORMATION, Messages.CANNOT_BORROW_SAME_COPY.getValue());
				txtID.requestFocus();
				return;
			}
		} else if (p != null) {
			if (!bookExists(p)) {
				data.add(new PaperItemDTO(p, p.getAvailableCopy()));
				table.setItems(data);
			} else {
				Common.showMessage(AlertType.INFORMATION, Messages.CANNOT_BORROW_SAME_COPY.getValue());
				txtID.requestFocus();
				return;
			}
		}
	}

	public void clickCheckout(ActionEvent event) {
		if (txtMemberID.getText() == null || txtMemberID.getText().equals("")) {
			Common.showMessage(AlertType.INFORMATION, "Member ID is not allowed empty!");
			txtMemberID.requestFocus();
			return;
		}
		if (data.isEmpty()) {
			Common.showMessage(AlertType.INFORMATION, "You have to select a book.");
			txtID.requestFocus();
			return;
		}

		Member m = memberDao.getMember(txtMemberID.getText());
		if (m == null) {
			Common.showMessage(AlertType.INFORMATION, Messages.NOT_EXIST_MEMBERID.getValue());
			txtMemberID.requestFocus();
			return;
		}

		List<PaperItem> items = new ArrayList<>();
		for(PaperItemDTO pid : data) {
			items.add(pid.getPi());
		}

		memberDao.checkOut(m, items);
		try {
			da.write(memberDao);
			da.write(bookDao);
			da.write(periodicalDao);
			String message = String.format(Messages.CHECKOUT_BOOK_SUCCESS.getValue(), m.getFirstName(), m.getMemberId(), items.size(), items);
			Common.showMessage(AlertType.INFORMATION, message);
			resetData();
		} catch (Exception e) {
			Common.showMessage(AlertType.ERROR, Messages.COMMON_INTERNAL_ERROR.getValue());
			e.printStackTrace();
		}
	}
	
	private boolean bookExists(PaperItem pi) {
		for (PaperItemDTO pid : data) {
			if (pid.getId().equals(pi.getId())) {
				return true;
			}
		}

		return false;
	}
	
	private void resetData() {
		data.clear();
		txtID.clear();
		txtMemberID.clear();
		txtMemberID.requestFocus();
	}
}
