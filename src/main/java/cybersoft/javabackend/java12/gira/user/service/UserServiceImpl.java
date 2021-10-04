package cybersoft.javabackend.java12.gira.user.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.java12.gira.user.dto.CreateUserDto;
import cybersoft.javabackend.java12.gira.user.dto.UserDto;
import cybersoft.javabackend.java12.gira.user.dto.UserProgramDto;
import cybersoft.javabackend.java12.gira.user.entity.User;
import cybersoft.javabackend.java12.gira.user.repository.UserRepository;
import cybersoft.javabackend.java12.gira.user.service.itf.UserService;
import cybersoft.javabackend.java12.gira.user.util.UserStatus;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository repository;
	private PasswordEncoder encoder;
	
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		repository = userRepository;
		this.encoder = passwordEncoder;
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
		return repository.countByUsername(username.toLowerCase()) >=1;
	}

	@Override
	public User addNewUser(CreateUserDto dto) {
		User newUser = new User();
		
		newUser.setUsername(dto.getUsername());
		newUser.setEmail(dto.getEmail());
		newUser.setPassword(encoder.encode(dto.getPassword()));
		newUser.setStatus(UserStatus.ACTIVE);
		
		
		return repository.save(newUser);
	}

	@Override
	public List<UserProgramDto> findAllProgramsOfUser(String username) {
		return repository.findAllProgramsByUsername(username);
	}
}
