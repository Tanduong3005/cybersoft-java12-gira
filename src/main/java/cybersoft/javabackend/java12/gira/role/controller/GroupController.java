package cybersoft.javabackend.java12.gira.role.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.java12.gira.common.util.ResponseHandler;
import cybersoft.javabackend.java12.gira.role.dto.AddRoleDto;
import cybersoft.javabackend.java12.gira.role.dto.AddUserDto;
import cybersoft.javabackend.java12.gira.role.dto.CreateGroupDto;
import cybersoft.javabackend.java12.gira.role.dto.GroupDto;
import cybersoft.javabackend.java12.gira.role.entity.Group;
import cybersoft.javabackend.java12.gira.role.entity.Role;
import cybersoft.javabackend.java12.gira.role.service.itf.GroupService;

@RestController
@RequestMapping("/api/group")
public class GroupController {
	private GroupService service;

	public GroupController(GroupService groupService) {
		service = groupService;
	}

	@GetMapping
	public Object findAllGroup() {
		List<GroupDto> groups = service.findAll();

		return ResponseHandler.getResponse(groups, HttpStatus.OK);
//		return new ResponseEntity<>(roles, HttpStatus.OK);
	}

	@PostMapping
	public Object saveGroup(@Valid @RequestBody CreateGroupDto dto, BindingResult errors) {
		if (errors.hasErrors())
			return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);
//			return new ResponseEntity<>(errors.getAllErrors(), HttpStatus.BAD_REQUEST);

		Group addedGroup = service.addNewGroup(dto);

		return ResponseHandler.getResponse(addedGroup, HttpStatus.OK);
	}

	@PostMapping("/add-role")
	public Object addRole(@Valid @RequestBody AddRoleDto dto, BindingResult errors) {
		if (errors.hasErrors())
			return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);

		Group updatedGroup = service.addRole(dto);

		return ResponseHandler.getResponse(updatedGroup, HttpStatus.OK);
	}

	@PostMapping("/remove-role")
	public Object removeRole(@Valid @RequestBody AddRoleDto dto, BindingResult errors) {
		if (errors.hasErrors())
			return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);

		Group updatedGroup = service.removeRole(dto);

		return ResponseHandler.getResponse(updatedGroup, HttpStatus.OK);
	}

	@PostMapping("/add-user")
	public Object addUserToGroup(@Valid @RequestBody AddUserDto dto, BindingResult errors) {
		if (errors.hasErrors())
			return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);

		Group updatedGroup = service.addUser(dto);

		return ResponseHandler.getResponse(updatedGroup, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public Object deleteGroup(@PathVariable("id") Long groupId) {
		return null;
	}
}
