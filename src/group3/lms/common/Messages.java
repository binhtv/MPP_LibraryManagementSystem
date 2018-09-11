package group3.lms.common;

public enum Messages {
	INPUT_USER_NAME("Please input user name!"),
	INPUT_PASSWORD("Please input password!"),
	INCORRECT_USER_PASS("User name or Password is incorrect."),;
	
	private String value;
	
	private Messages(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
