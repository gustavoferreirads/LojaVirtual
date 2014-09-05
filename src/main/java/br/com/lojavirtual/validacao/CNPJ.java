package br.com.lojavirtual.validacao;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;



@Documented
@Constraint(validatedBy = CnpjValidator.class)
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CNPJ {
	String message() default "{validator.cnpj_invalido}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}