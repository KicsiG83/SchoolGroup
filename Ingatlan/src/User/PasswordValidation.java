package User;

public class PasswordValidation{
	public int calculatePasswordStrength(String password) {

		int iPasswordScore = 0;

		if (password.length() < 8)
			return 0;
		else
			iPasswordScore += 1;

		if (password.matches("(?=.*[0-9]).*"))
			iPasswordScore += 1;

		if (password.matches("(?=.*[a-z]).*"))
			iPasswordScore += 1;

		if (password.matches("(?=.*[A-Z]).*"))
			iPasswordScore += 1;

		return iPasswordScore;

	}

}
