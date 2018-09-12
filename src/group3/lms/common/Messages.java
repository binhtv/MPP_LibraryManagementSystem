package group3.lms.common;

public enum Messages {
	COMMON_INTERNAL_ERROR("Unknow error occurred, please try again."),
	COMMON_SUCCESS_MESSAGE("Your changes have been saved successfully."),
	
	INPUT_ISBN("Please input ISBN of book!"),
	INPUT_NUM_OF_COPY("Please input number of copy!"),
	NOT_EXIST_ISBN("ISBN does not exist."),
	INPUT_USER_NAME("Please input user name!"),
	INPUT_PASSWORD("Please input password!"),
	INPUT_CREATENEWMEMBER("Do you want to create a new member?"),
	INCORRECT_USER_PASS("User name or Password is incorrect."),
	
	NEW_MEMBER_CANCEL("Are you sure to exit to Home Screen?"),
	
	TITLE_LOGIN("Please Login"),
	TITLE_MAIN_SCREEN("Welcome To Library Management System"),
	TITLE_ADD_NEW_MEMBER("Add new member");
	
	private String value;
	
	private Messages(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
