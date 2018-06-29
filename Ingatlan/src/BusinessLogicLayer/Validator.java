package BusinessLogicLayer;

public class Validator {

	public boolean isValidMenuChoice(String s) {
		try {
			int num = Integer.parseInt(s);
			if (num < 0 || num > 5) {
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
		System.out.println("A megadott érték érvénytelen.");
	}

	public boolean isValidEmailAddress(String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,7}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}

	public boolean checkPasswordStrength(String password) {
		boolean isValidPassword = false;
		if (password.matches("(^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(.{8,})$)")) {
			isValidPassword = true;
		}else {
			System.out.println("A megadott jelszó nem elég erős.\n(A jelszó tartalmaazzon legalább 1 kis és nagybetűt és legalább 1 számot, minimum 8 karakter hosszú.)");
		}
		return isValidPassword;
	}
	
}
