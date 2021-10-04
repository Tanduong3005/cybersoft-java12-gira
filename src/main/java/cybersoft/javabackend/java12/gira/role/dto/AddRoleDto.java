package cybersoft.javabackend.java12.gira.role.dto;

import javax.validation.constraints.Min;

import com.sun.istack.NotNull;

import cybersoft.javabackend.java12.gira.role.validation.annotation.ExitsGroupId;
import cybersoft.javabackend.java12.gira.role.validation.annotation.ExitsRoleId;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddRoleDto {

	@NotNull
	@Min(value = 1)
	@ExitsGroupId
	private Long groupId;

	@NotNull
	@Min(value = 1)
	@ExitsRoleId
	private Long roleId;

}
