package cybersoft.javabackend.java12.gira.role.dto;

import javax.validation.constraints.Min;

import com.sun.istack.NotNull;

import cybersoft.javabackend.java12.gira.role.validation.annotation.ExitsGroupId;
import cybersoft.javabackend.java12.gira.role.validation.annotation.ExitsRoleId;

public class AddRoleDto {

	@NotNull
	@Min(value = 1)
	@ExitsGroupId
	private Long groupId;

	@NotNull
	@Min(value = 1)
	@ExitsRoleId
	private Long roleId;

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

}
