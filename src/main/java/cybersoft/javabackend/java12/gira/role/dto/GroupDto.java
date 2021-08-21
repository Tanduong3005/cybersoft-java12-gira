package cybersoft.javabackend.java12.gira.role.dto;

import java.util.Set;

public interface GroupDto {

	//projection
	public Long getId();
	public String getName();
	public String getDescription();
	public Set<RoleDto> getRoles();
}
