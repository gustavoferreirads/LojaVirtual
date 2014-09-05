package br.com.lojavirtual.validacao;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.lojavirtual.util.Strings;


public class PisValidator implements ConstraintValidator<ValidaPIS, String> {

	@Override
	public void initialize(ValidaPIS validaPiss) {}

	@Override
	public boolean isValid(String numeroPis, ConstraintValidatorContext arg1) {
		if (Strings.isNullOrEmpty(numeroPis)) {
			return true;
		}
		numeroPis = numeroPis.replace('.', ' ').replace('-', ' ').replaceAll(" ", "");
		int liTamanho = 0;
		StringBuffer lsAux = null;
		StringBuffer lsMultiplicador = new StringBuffer("3298765432");
		int totalizador = 0;
		int resto = 0;
		int multiplicando = 0;
		int multiplicador = 0;
		boolean lbRetorno = true;
		int digito = 99;

		lsAux = new StringBuffer().append(numeroPis);
		liTamanho = lsAux.length();

		if (liTamanho != 11) {
			lbRetorno = false;
		}

		if (lbRetorno) {
			for (int i = 0; i < 10; i++) {

				multiplicando = Integer.parseInt(lsAux.substring(i, i + 1));
				multiplicador = Integer.parseInt(lsMultiplicador.substring(i, i + 1));
				totalizador += multiplicando * multiplicador;
			}

			resto = 11 - totalizador % 11;
			resto = resto == 10 || resto == 11 ? 0 : resto;

			digito = Integer.parseInt("" + lsAux.charAt(10));
			lbRetorno = resto == digito;
		}

		return lbRetorno;
	}

}
