package cybersoft.javabackend.java12.gira.role.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cybersoft.javabackend.java12.gira.common.util.ValidatorUtils;
import cybersoft.javabackend.java12.gira.role.validation.annotation.ValidDescription;

public class ValidDescriptionValidator implements ConstraintValidator<ValidDescription, String> {

	private String message;

	@Override
	public void initialize(ValidDescription constraintAnnotation) {
		this.message = constraintAnnotation.message();
	}

	@Override
	public boolean isValid(String roleDescription, ConstraintValidatorContext context) {
		// check blank
		if (roleDescription == null) {
			ValidatorUtils.addError(context, message);
			return false;
		}

		roleDescription = roleDescription.trim();
		// check lenght
		if (roleDescription.length() < 10) {
			ValidatorUtils.addError(context, message);
			return false;
		}
		return true;
	}

}
