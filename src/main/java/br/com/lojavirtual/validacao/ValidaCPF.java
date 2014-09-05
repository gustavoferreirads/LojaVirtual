package br.com.lojavirtual.validacao;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;



@Documented
@Constraint(validatedBy = CpfValidator.class)
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidaCPF {
	String message() default "{validator.cpf_invalido}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}