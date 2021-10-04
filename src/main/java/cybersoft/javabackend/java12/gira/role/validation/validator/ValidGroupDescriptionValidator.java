package cybersoft.javabackend.java12.gira.role.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cybersoft.javabackend.java12.gira.common.util.ValidatorUtils;
import cybersoft.javabackend.java12.gira.role.validation.annotation.ValidGroupDescription;

public class ValidGroupDescriptionValidator implements ConstraintValidator<ValidGroupDescription, String> {

	private String message;
	
	@Override
	public void initialize(ValidGroupDescription constraintAnnotation) {
		this.message = constraintAnnotation.message();
	}

	@Override
	public boolean isValid(String groupDescription, ConstraintValidatorContext context) {
		// check blank
		if (groupDescription == null) {
			ValidatorUtils.addError(context, message);
			return false;
		}

		groupDescription = groupDescription.trim();
		// check lenght
		if (groupDescription.length() < 10) {
			ValidatorUtils.addError(context, message);
			return false;
		}
		return true;
	}

}
