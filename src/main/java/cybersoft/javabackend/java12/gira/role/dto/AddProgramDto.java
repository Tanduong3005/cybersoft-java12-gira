package cybersoft.javabackend.java12.gira.role.dto;

import javax.validation.constraints.Min;

import com.sun.istack.NotNull;

import cybersoft.javabackend.java12.gira.role.validation.annotation.ExitsProgramId;
import cybersoft.javabackend.java12.gira.role.validation.annotation.ExitsRoleId;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddProgramDto {

	@NotNull
	@Min(value = 1)
	@ExitsRoleId
	private Long roleId;

	@NotNull
	@Min(value = 1)
	@ExitsProgramId
	private Long programId;

}
