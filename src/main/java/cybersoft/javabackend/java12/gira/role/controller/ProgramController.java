package cybersoft.javabackend.java12.gira.role.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.java12.gira.common.util.ResponseHandler;
import cybersoft.javabackend.java12.gira.role.dto.CreateProgramDto;
import cybersoft.javabackend.java12.gira.role.dto.ProgramDto;
import cybersoft.javabackend.java12.gira.role.entity.Program;
import cybersoft.javabackend.java12.gira.role.service.itf.ProgramService;

@RestController
@RequestMapping("api/program")
public class ProgramController {
	private ProgramService service;
	
	public ProgramController(ProgramService programService) {
		service = programService;
	}
	
	@GetMapping
	public Object findAllProgram() {
		List<ProgramDto> programs = service.findAll();
		
		return ResponseHandler.getResponse(programs, HttpStatus.OK);
//		return new ResponseEntity<>(roles, HttpStatus.OK);
	}

	@PostMapping
	public Object saveProgram(@Valid @RequestBody CreateProgramDto dto, BindingResult errors) {
		if(errors.hasErrors())
			return ResponseHandler.getResponse(HttpStatus.BAD_REQUEST);

		Program addedProgram = service.addNewProgram(dto);

		return ResponseHandler.getResponse(addedProgram, HttpStatus.CREATED);
	}
	
}
