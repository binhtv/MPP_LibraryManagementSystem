package group3.lms.common;

public enum Messages {
	COMMON_INTERNAL_ERROR("Unknow error occurred, please try again."),
	COMMON_SUCCESS_MESSAGE("Your changes have been saved successfully."),
	//INPUT MESSAGES
	INPUT_ISBN("Please input ISBN of book!"),
	INPUT_NUM_OF_COPY("Please input number of copy!"),
	INPUT_USER_NAME("Please input user name!"),
	INPUT_PASSWORD("Please input password!"),
	INPUT_CREATENEWMEMBER("Do you want to create a new member?"),	
	
	//NOT EXISTS MESSAGES
	NOT_EXIST_ISBN("ISBN does not exist."),
	NOT_EXIST_MEMBERID("Member ID does not exist."),
	
	//NOT AVAILABLE
	NOT_AVAILABLE_COPYBOOK("Copy books are not available."),
	
	//INCORRECT MESSAGES
	INCORRECT_USER_PASS("User name or Password is incorrect."),
	
	NEW_MEMBER_CANCEL("Are you sure to exit to Home Screen?"),
	
	//TITLE
	TITLE_LOGIN("Please Login"),
	TITLE_MAIN_SCREEN("Welcome To Library Management System"),
	TITLE_ADD_NEW_MEMBER("Add new member"),
	TITLE_ADD_CHECKOUT("Checkout Books"),;
	
	private String value;
	
	private Messages(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
