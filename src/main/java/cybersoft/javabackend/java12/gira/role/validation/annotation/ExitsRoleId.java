package cybersoft.javabackend.java12.gira.role.validation.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.javabackend.java12.gira.role.validation.validator.ExitsRoleIdValidator;

@Constraint(validatedBy = ExitsRoleIdValidator.class)
@Retention(RUNTIME)
@Target(FIELD)
public @interface ExitsRoleId {
	public String message() default "Role doesn't exits";
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
