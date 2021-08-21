package cybersoft.javabackend.java12.gira.user.service;

import java.util.List;


import org.springframework.stereotype.Service;

import cybersoft.javabackend.java12.gira.user.dto.CreateUserDto;
import cybersoft.javabackend.java12.gira.user.dto.UserDto;
import cybersoft.javabackend.java12.gira.user.entity.User;
import cybersoft.javabackend.java12.gira.user.repository.UserRepository;
import cybersoft.javabackend.java12.gira.user.service.itf.UserService;
import cybersoft.javabackend.java12.gira.user.util.UserStatus;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository repository;
//	private PasswordEncoder passwordEncoder;
	public UserServiceImpl(UserRepository userRepository) {
		repository = userRepository;
//		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public List<UserDto> findAllDto() {
		// TODO Auto-generated method stub
		return repository.findAllUserDto();
	}

	@Override
	public boolean isTakenEmail(String email) {
		return repository.countByEmail(email) >=1;
	}

	@Override
	public boolean isTakenUsername(String username) {
		return repository.countByUsername(username.toUpperCase()) >=1;
	}

	@Override
	public User addNewUser(CreateUserDto dto) {
		User newUser = new User();
		
		newUser.setUsername(dto.getUsername().toUpperCase());
		newUser.setEmail(dto.getEmail());
		newUser.setPassword(dto.getPassword());
		newUser.setStatus(UserStatus.ACTIVE);
		
		
		return repository.save(newUser);
	}
}
