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

	public static boolean isValidEmailAddress(String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,7}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}

}
