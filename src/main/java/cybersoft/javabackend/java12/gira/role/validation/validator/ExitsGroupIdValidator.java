package cybersoft.javabackend.java12.gira.role.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cybersoft.javabackend.java12.gira.common.util.ValidatorUtils;
import cybersoft.javabackend.java12.gira.role.service.itf.GroupService;
import cybersoft.javabackend.java12.gira.role.validation.annotation.ExitsGroupId;

public class ExitsGroupIdValidator implements ConstraintValidator<ExitsGroupId, Long> {

	private String message;
	private GroupService service;

	public ExitsGroupIdValidator(GroupService groupService) {
		service = groupService;
	}

	@Override
	public void initialize(ExitsGroupId constraintAnnotation) {
		this.message = constraintAnnotation.message();
	}

	@Override
	public boolean isValid(Long groupId, ConstraintValidatorContext context) {
		boolean isExisted = service.isExistedId(groupId);
		
		if(isExisted)
			return true;
		
		ValidatorUtils.addError(context, message);
		return false;
	}

}
