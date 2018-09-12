package group3.lms.common;

public enum Messages {
	COMMON_INTERNAL_ERROR("Unknow error occurred, please try again."),
	COMMON_SUCCESS_MESSAGE("Your changes have been saved successfully."),
	//INPUT MESSAGES
	INPUT_ISBN("ISBN of book is not allowed empty!"),
	INPUT_NUM_OF_COPY("Number of copy is not allowed empty!"),
	INPUT_USER_NAME("User name is not allowed empty!"),
	INPUT_PASSWORD("Password is not allowed empty!"),
	INPUT_CREATENEWMEMBER("Do you want to create a new member?"),
	INPUT_NOT_NUMBER("Please input a number!"),	
	
	//NOT EXISTS MESSAGES
	NOT_EXIST_ISBN("ISBN does not exist."),
	NOT_EXIST_MEMBERID("Member ID does not exist."),
	
	//NOT AVAILABLE
	NOT_AVAILABLE_COPYBOOK("Copy books or periodicals are not available."),
	CANNOT_BORROW_SAME_COPY("You cannot borrow the same book."),
	
	//INCORRECT MESSAGES
	INCORRECT_USER_PASS("User name or Password is incorrect."),
	
	NEW_MEMBER_CANCEL("Are you sure to exit to Home Screen?"),
	
	//TITLE
	TITLE_LOGIN("Please Login"),
	TITLE_MAIN_SCREEN("Welcome To Library Management System"),
	TITLE_ADD_NEW_MEMBER("Add new member"),
	TITLE_ADD_CHECKOUT("Checkout Books"),
	TITLE_ADD_BOOK_COPY("Add book copy"),
	CHECKOUT_BOOK_SUCCESS("Checkout success for member %s, ID: %s, %s books\n%s");
	
	private String value;
	
	private Messages(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
