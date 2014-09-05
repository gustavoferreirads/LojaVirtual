package br.com.lojavirtual.validacao;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExitoValidator implements ConstraintValidator<ValidaExito, Short> {

	@Override
	public void initialize(ValidaExito arg0) {
	}

	@Override
	public boolean isValid(Short exito, ConstraintValidatorContext arg1) {
		if (exito == null) {
			return true;
		}
		
		return exitoValido(exito);
	}

	private boolean exitoValido(Short exito) {
		if ((exito >= 0) && (exito <= 100)) {
			return true;
		} else {
			return false;
		}
	}

}
