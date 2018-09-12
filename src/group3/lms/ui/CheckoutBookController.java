package group3.lms.ui;

import java.util.ArrayList;
import java.util.List;

import group3.lms.business.BookDao;
import group3.lms.business.MemberDao;
import group3.lms.business.PeriodicalDao;
import group3.lms.business.entity.Book;
import group3.lms.business.entity.Member;
import group3.lms.business.entity.PaperItem;
import group3.lms.business.entity.Periodical;
import group3.lms.common.Common;
import group3.lms.common.Messages;
import group3.lms.dataaccess.DataAccess;
import group3.lms.dataaccess.impl.DataAccessFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CheckoutBookController {
	@FXML
	private Button btnCheckout;
	@FXML
	private TextField txtMemberID;
	@FXML
	private TextField txtID;
	
	private List<PaperItem> pis;
	
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
		
		pis = new ArrayList<>();
	}

	@FXML
	protected void initialize() {
		txtMemberID.requestFocus();
	}

	public void clickCheckout(ActionEvent event) {
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

		Member m = memberDao.getMember(txtMemberID.getText().toLowerCase());
		if (m == null) {
			Common.showMessage(AlertType.INFORMATION, Messages.NOT_EXIST_MEMBERID.getValue());
			txtMemberID.requestFocus();
			return;
		}

		// get Book from stored file
		Book b = bookDao.getBookByISBN(txtID.getText().toLowerCase());
		Periodical p = null;
		if (b == null) {
			p = periodicalDao.getBookById(txtID.getText().toLowerCase());
		}

		if (b == null && p == null) {
			Common.showMessage(AlertType.INFORMATION, Messages.NOT_EXIST_ISBN.getValue());
			txtID.requestFocus();
			return;
		}

		if (b != null && bookDao.isAvailable(b)) {
			Common.showMessage(AlertType.INFORMATION, Messages.NOT_AVAILABLE_COPYBOOK.getValue());
			txtID.requestFocus();
			return;
		}

		if (p != null && periodicalDao.isAvailable(p)) {
			Common.showMessage(AlertType.INFORMATION, Messages.NOT_AVAILABLE_COPYBOOK.getValue());
			txtID.requestFocus();
			return;
		}
		
//		memberDao.checkOut(m, pis);
		Common.showMessage(AlertType.INFORMATION, Messages.COMMON_SUCCESS_MESSAGE.getValue());
	}
}
