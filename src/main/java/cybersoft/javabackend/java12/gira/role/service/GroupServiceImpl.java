package cybersoft.javabackend.java12.gira.role.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cybersoft.javabackend.java12.gira.role.dto.AddRoleDto;
import cybersoft.javabackend.java12.gira.role.dto.AddUserDto;
import cybersoft.javabackend.java12.gira.role.dto.CreateGroupDto;
import cybersoft.javabackend.java12.gira.role.dto.GroupDto;
import cybersoft.javabackend.java12.gira.role.entity.Group;
import cybersoft.javabackend.java12.gira.role.entity.Role;
import cybersoft.javabackend.java12.gira.role.repository.GroupRepository;
import cybersoft.javabackend.java12.gira.role.repository.RoleRepository;
import cybersoft.javabackend.java12.gira.role.service.itf.GroupService;
import cybersoft.javabackend.java12.gira.user.entity.User;
import cybersoft.javabackend.java12.gira.user.repository.UserRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
@Transactional(readOnly = true)
public class GroupServiceImpl implements GroupService {
	private GroupRepository repository;
	private RoleRepository roleRepository;
	private UserRepository userRepository;
	

	@Override
	public List<GroupDto> findAll() {
		return repository.findAllDto();
	}

	@Override
	public Group addNewGroup(CreateGroupDto dto) {
		Group newGroup = new Group();

		newGroup.setName(dto.getName());
		newGroup.setDescription(dto.getDescription());

		return repository.save(newGroup);
	}

	@Override
	public Group addRole( AddRoleDto dto) {
		Group group = repository.getById(dto.getGroupId());
		Role role = roleRepository.getById(dto.getRoleId());

		group.addRole(role);

		return repository.save(group);
	}

	@Override
	public Group removeRole( AddRoleDto dto) {
		Group group = repository.getById(dto.getGroupId());
		Role role = roleRepository.getById(dto.getRoleId());

		group.removeRole(role);

		return repository.save(group);
	}

	@Override
	public boolean isTakenName(String groupName) {
		return repository.countByName(groupName) >= 1;
	}

	@Override
	public boolean isExistedId(Long groupId) {
		return repository.existsById(groupId);
	}

	@Override
	public Group addUser( AddUserDto dto) {
		Group group = repository.getById(dto.getGroupId());
		User user = userRepository.getById(dto.getUserId());
		return group.addUser(user);
	}
}
