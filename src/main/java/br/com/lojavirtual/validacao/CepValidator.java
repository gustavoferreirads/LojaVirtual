package br.com.lojavirtual.validacao;

import br.com.lojavirtual.util.Strings;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CepValidator implements ConstraintValidator<CEP, String> {

	@Override
	public void initialize(CEP arg0) {
	}

	@Override
	public boolean isValid(String cep, ConstraintValidatorContext arg1) {
		if (Strings.isNullOrEmpty(cep)) {
			return true;
		}
		
		return cepEhValido(cep);
	}

	private boolean cepEhValido(String cep) {
		cep = cep.replace("-", "");
		return cep.length() == 8 && cep.matches("\\d+");
	}

}
