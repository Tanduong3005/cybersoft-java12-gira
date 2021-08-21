package cybersoft.javabackend.java12.gira.role.service.itf;

import java.util.List;

import javax.validation.Valid;

import cybersoft.javabackend.java12.gira.role.dto.AddRoleDto;
import cybersoft.javabackend.java12.gira.role.dto.CreateGroupDto;
import cybersoft.javabackend.java12.gira.role.dto.GroupDto;
import cybersoft.javabackend.java12.gira.role.entity.Group;
import cybersoft.javabackend.java12.gira.role.entity.Role;

public interface GroupService {
	// contrat
	List<GroupDto> findAll();

	Group addNewGroup(CreateGroupDto dto);

	Group addRole(@Valid AddRoleDto dto);

	Group removeRole(@Valid AddRoleDto dto);

	boolean isTakenName(String groupName);

	boolean isExistedId(Long groupId);
}
