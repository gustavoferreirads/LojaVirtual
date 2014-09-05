package br.com.lojavirtual.validacao;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Documented
@Constraint(validatedBy = PisValidator.class)
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidaPIS {
	
	String message() default "{validator.pis_invalido}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
