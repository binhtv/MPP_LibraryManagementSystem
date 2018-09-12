package group3.lms.ui;

import group3.lms.business.BookDao;
import group3.lms.business.MemberDao;
import group3.lms.business.entity.Book;
import group3.lms.business.entity.Member;
import group3.lms.business.entity.PaperItem;
import group3.lms.business.entity.PaperItemCopy;
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

	public void clickCheckout(ActionEvent event) {
		if (txtMemberID.getText() == null || txtMemberID.getText().equals(""))
		{
			Common.ShowMessage(AlertType.INFORMATION, "Member ID is not allowed empty!");
			txtMemberID.requestFocus();
		}
		else if (txtID.getText() == null || txtID.getText().equals(""))
		{
			Common.ShowMessage(AlertType.INFORMATION, "Book ISBN/ID is not allowed empty!");
			txtID.requestFocus();
		}
		else
		{
			// Read from the stored file
			DataAccess da = DataAccessFactory.getDataAccess();
			//get member from stored file
			MemberDao memberDao = new MemberDao();
			da.read(memberDao);
			Member m = memberDao.getMember(txtMemberID.getText().toLowerCase());	
			//get Book from stored file
			BookDao bookDao = new BookDao();
			da.read(bookDao);
			Book b = bookDao.getBookByISBN(txtID.getText().toLowerCase());
			
			if (m == null)
			{
				Common.ShowMessage(AlertType.INFORMATION, Messages.NOT_EXIST_MEMBERID.getValue());
				txtMemberID.requestFocus();
			}
			else if (b == null)
			{
				Common.ShowMessage(AlertType.INFORMATION, Messages.NOT_EXIST_ISBN.getValue());
				txtID.requestFocus();
			}
			else if (PaperItemCopy.getPaperItemCopy_ByBook_Available(b) == null)
			{
				Common.ShowMessage(AlertType.INFORMATION, Messages.NOT_AVAILABLE_COPYBOOK.getValue());
				txtID.requestFocus();
			}
			else
			{}
		}
	}
}
