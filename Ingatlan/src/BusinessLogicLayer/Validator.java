package BusinessLogicLayer;

public class Validator {
	public boolean isValidLimitValue(String value) {
		try {
			int result = Integer.parseInt(value);
			if(result>0) {
				return true;
			}
			
		} catch(Exception e) {			
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
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,7}))$";
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
	
	public boolean checkPhoneNumber(String phoneNumber){
		boolean isValidPhoneNumber = false;
		if(phoneNumber.length()<9 || phoneNumber.length()>9) {
			
		}else {
			try {
				Integer num = Integer.valueOf(phoneNumber);
				isValidPhoneNumber = true;
			} catch (NumberFormatException e) {
				System.out.println("A megadott adat érvénytelen.");
				isValidPhoneNumber = false;
			}
		}
		return isValidPhoneNumber;
	}
}
