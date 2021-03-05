package com.robertrice.odinsstudy.annotations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
//custom rules for custom email constraint
public class EmailValidator implements ConstraintValidator<EmailConstraint, String> {
	
	//set up regex rules defining what an email should look like
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9]+\\.[A-Z]{2,6}$", 
			Pattern.CASE_INSENSITIVE);
	// validate user input matches expected regex
	public static boolean  validate(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}
	
	// make sure email is valid
	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext context) {
		return (validate(arg0) && (arg0.length() > 8) && (arg0.length() < 25));
	}

}
