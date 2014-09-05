package br.com.lojavirtual.validacao;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Documented
@Constraint(validatedBy = ExitoValidator.class)
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidaExito {
	String message() default "{validator.exito}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}