package br.com.lojavirtual.validacao;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.lojavirtual.util.Strings;


public class CpfValidator implements ConstraintValidator<ValidaCPF, String> {

	@Override
	public void initialize(ValidaCPF anotacao) {

	}

	@Override
	public boolean isValid(String cpf, ConstraintValidatorContext context) {
		if (Strings.isNullOrEmpty(cpf)) {
			return true;
		}
		
		cpf = cpf.replace('.', ' ').replace('-', ' ').replaceAll(" ", "");

		boolean cpfEhValido = false;
		String base = "000000000";
		String digitos = "00";
		if (cpf.length() <= 11) {
			if (cpf.length() < 11) {
				cpf = base.substring(0, 11 - cpf.length()) + cpf;
				base = cpf.substring(0, 9);
			}
			base = cpf.substring(0, 9);
			digitos = cpf.substring(9, 11);
			int soma = 0, mult = 11;
			int[] var = new int[11];
			for (int i = 0; i < 9; i++) {
				var[i] = Integer.parseInt("" + cpf.charAt(i));
				if (i < 9)
					soma += (var[i] * --mult);
			}
			int resto = soma % 11;
			if (resto < 2) {
				var[9] = 0;
			} else {
				var[9] = 11 - resto;
			}
			soma = 0;
			mult = 11;
			for (int i = 0; i < 10; i++)
				soma += var[i] * mult--;
			resto = soma % 11;
			if (resto < 2) {
				var[10] = 0;
			} else {
				var[10] = 11 - resto;
			}
			if ((digitos.substring(0, 1).equalsIgnoreCase(new Integer(var[9]).toString())) && (digitos.substring(1, 2).equalsIgnoreCase(new Integer(var[10]).toString()))) {
				cpfEhValido = true;
			}
		}
		return cpfEhValido;
	}
}
