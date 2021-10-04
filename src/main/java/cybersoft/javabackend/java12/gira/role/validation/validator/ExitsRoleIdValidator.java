package cybersoft.javabackend.java12.gira.role.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cybersoft.javabackend.java12.gira.common.util.ValidatorUtils;
import cybersoft.javabackend.java12.gira.role.service.itf.RoleService;
import cybersoft.javabackend.java12.gira.role.validation.annotation.ExitsRoleId;

public class ExitsRoleIdValidator implements ConstraintValidator<ExitsRoleId, Long>{

	private String message;
	private RoleService service;
	
	public ExitsRoleIdValidator(RoleService roleService) {
		service = roleService;
	}
	
	@Override
	public void initialize(ExitsRoleId constraintAnnotation) {
		this.message = constraintAnnotation.message();
	}
	
	@Override
	public boolean isValid(Long roleId, ConstraintValidatorContext context) {
		boolean isExisted = service.isExistedId(roleId);
		
		if(isExisted)
			return true;
		
		ValidatorUtils.addError(context, message);
		return false;
	}

}
