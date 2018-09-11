package group3.lms.common;

public enum Messages {
	INPUT_USER_NAME("Please input user name!"),
	INPUT_PASSWORD("Please input password!"),
	INPUT_CREATENEWMEMBER("Do you want to create a new member?"),
	INCORRECT_USER_PASS("User name or Password is incorrect."),
	
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
