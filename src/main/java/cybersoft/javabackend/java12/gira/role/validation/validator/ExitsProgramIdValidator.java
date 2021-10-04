package cybersoft.javabackend.java12.gira.role.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cybersoft.javabackend.java12.gira.common.util.ValidatorUtils;
import cybersoft.javabackend.java12.gira.role.service.itf.ProgramService;
import cybersoft.javabackend.java12.gira.role.validation.annotation.ExitsProgramId;

public class ExitsProgramIdValidator implements ConstraintValidator<ExitsProgramId, Long>{

	private String message;
	private ProgramService service;
	
	public ExitsProgramIdValidator(ProgramService programService) {
		service = programService;
	}
	
	@Override
	public void initialize(ExitsProgramId constraintAnnotation) {
		message = constraintAnnotation.message();
	}
	
	@Override
	public boolean isValid(Long programId, ConstraintValidatorContext context) {
		boolean isExisted = service.isExistedId(programId);
		
		if(isExisted)
			return true;
		
		ValidatorUtils.addError(context, message);
		return false;
	}

}
