package cybersoft.javabackend.java12.gira.role.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cybersoft.javabackend.java12.gira.role.service.itf.RoleService;
import cybersoft.javabackend.java12.gira.role.validation.annotation.UnipueRoleName;

public class UnipueRoleNameValidator implements ConstraintValidator<UnipueRoleName, String>{
	
	private String message;
	private RoleService service;
	
	public UnipueRoleNameValidator(RoleService roleService) {
		service = roleService;
	}
	
	@Override
	public void initialize(UnipueRoleName constraintAnnotation) {
		this.message = constraintAnnotation.message();
	}
	
	@Override
	public boolean isValid(String roleName, ConstraintValidatorContext context) {
		boolean isTaken = service.isTakenName(roleName);
		
		if(!isTaken)
			return true;
		
		context.buildConstraintViolationWithTemplate(message)
		.addConstraintViolation()
		.disableDefaultConstraintViolation();
		return false;
	}
	
}
