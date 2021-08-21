package cybersoft.javabackend.java12.gira.role.dto;

import javax.validation.constraints.Min;

import com.sun.istack.NotNull;

import cybersoft.javabackend.java12.gira.role.validation.annotation.ExitsProgramId;
import cybersoft.javabackend.java12.gira.role.validation.annotation.ExitsRoleId;


public class AddProgramDto {

	@NotNull
	@Min(value = 1)
	@ExitsRoleId
	private Long roleId;

	@NotNull
	@Min(value = 1)
	@ExitsProgramId
	private Long programId;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getProgramId() {
		return programId;
	}

	public void setProgramId(Long programId) {
		this.programId = programId;
	}

}
