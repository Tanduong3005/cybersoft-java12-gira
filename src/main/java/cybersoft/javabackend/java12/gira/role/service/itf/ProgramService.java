package cybersoft.javabackend.java12.gira.role.service.itf;

import java.util.List;

import cybersoft.javabackend.java12.gira.role.dto.CreateProgramDto;
import cybersoft.javabackend.java12.gira.role.dto.ProgramDto;
import cybersoft.javabackend.java12.gira.role.entity.Program;

//astraction
public interface ProgramService {
	// contrat
	List<ProgramDto> findAll();

	Program addNewProgram(CreateProgramDto dto);
}
