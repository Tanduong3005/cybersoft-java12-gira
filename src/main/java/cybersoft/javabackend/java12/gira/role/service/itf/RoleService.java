package cybersoft.javabackend.java12.gira.role.service.itf;

import java.util.List;

import javax.validation.Valid;

import cybersoft.javabackend.java12.gira.role.dto.AddProgramDto;
import cybersoft.javabackend.java12.gira.role.dto.CreateRoleDto;
import cybersoft.javabackend.java12.gira.role.dto.RoleDto;
import cybersoft.javabackend.java12.gira.role.entity.Role;

//astraction
public interface RoleService {
	//contrat
	List<RoleDto> findAll();

	Role addNewRole(CreateRoleDto dto);
	
	Role addProgram(AddProgramDto dto);

	boolean isTakenName(String roleName);

	boolean isExistedId(Long roleId);
	
	Role removeProgram(@Valid AddProgramDto dto);
}
