package BusinessLogicLayer;

public class Validator {
	public boolean isValidLimitValue(String value) {
		try {
			int result = Integer.parseInt(value);
			if (result > 0) {
				return true;
			}

		} catch (Exception e) {
		}
		return false;
	}

	public boolean isValidMenuChoice(String s, int numberOfOptions) {
		try {
			int num = Integer.parseInt(s);
			if (num <= 0 || num > numberOfOptions) {
				printError();
				return false;
			}
		} catch (Exception e) {
			printError();
			return false;
		}
		return true;
	}
	
	public boolean isValidMenuChoice(int s, int numberOfOptions) {
		try {
			int num = s;
			if (num <= 0 || num > numberOfOptions) {
				printError();
				return false;
			}
		} catch (Exception e) {
			printError();
			return false;
		}
		return true;
	}

	private void printError() {
		System.out.println("													A megadott érték érvénytelen!");
	}

	public boolean isValidEmailAddress(String email) {
		String ePattern = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}

	public boolean checkPasswordStrength(String password) {
		boolean isValidPassword = false;
		if (password.matches("(^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(.{8,})$)")) {
			isValidPassword = true;
		}
		return isValidPassword;
	}

	public boolean checkPhoneNumber(String phoneNumber) {
		String pattern = "^[20,30,31,70]{2}[1-9]{1}[0-9]{6}$";
		if (phoneNumber.matches(pattern)) {
			return true;
		} else {
			return false;
		}
	}
}
