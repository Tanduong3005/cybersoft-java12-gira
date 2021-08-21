package cybersoft.javabackend.java12.gira.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cybersoft.javabackend.java12.gira.user.dto.UserDto;
import cybersoft.javabackend.java12.gira.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Transactional(readOnly = true)
	@Query("SELECT u FROM User u") //JPQL
	List<UserDto> findAllUserDto();

	int countByEmail(String email);

	int countByUsername(String username);

}
