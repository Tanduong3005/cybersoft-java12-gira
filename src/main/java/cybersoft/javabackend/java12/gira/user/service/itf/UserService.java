package cybersoft.javabackend.java12.gira.user.service.itf;

import java.util.List;

import javax.validation.Valid;

import cybersoft.javabackend.java12.gira.user.dto.CreateUserDto;
import cybersoft.javabackend.java12.gira.user.dto.UserDto;
import cybersoft.javabackend.java12.gira.user.entity.User;

public interface UserService {

	List<UserDto> findAllDto();

	boolean isTakenEmail(String email);

	boolean isTakenUsername(String username);

	User addNewUser(CreateUserDto dto);

}
