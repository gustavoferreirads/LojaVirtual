package br.com.lojavirtual.impl.servico;

import br.com.lojavirtual.api.modelo.File;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class FileValidator implements Validator {


    public boolean supports(Class<?> paramClass) {
		return File.class.equals(paramClass);
	}

	public void validate(Object obj, Errors errors) {
		File file = (File) obj;
		  if (file.getFile()[0].getSize() == 0) {
		   errors.rejectValue("file", "valid.file");
		  }
	}
}