package br.com.lojavirtual.validacao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.lojavirtual.util.Strings;


public class EmailValidator implements ConstraintValidator<Email, String> {

	@Override
	public void initialize(Email email) {}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		if (Strings.isNullOrEmpty(email)) {
			return true;
		}
	    Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+([_.-]?[0-9a-zA-Z]+)*@[0-9a-zA-Z]+[0-9,a-z,A-Z,.,-]*(.){1}[a-zA-Z]{2,4})+$");
	    Matcher matcher = pattern.matcher(email);

	    return matcher.matches();
	}

}
