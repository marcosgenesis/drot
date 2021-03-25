package br.com.pi.drot.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation{

	public static boolean emailEValido(String email) {
		boolean emailValido = false;

		if (email != null && email.length() > 0) {
			String expressaoRegularEmail = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";

			Pattern pattern = Pattern.compile(expressaoRegularEmail, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(email);

			if (matcher.matches()) {
				emailValido = true;
			}
		}

		return emailValido;
	}

}
