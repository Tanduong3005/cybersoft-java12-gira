package cybersoft.javabackend.java12.gira.role.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
	@GetMapping("/role")
	public Object role() {
		return "welcome to Gira Application Role module.";
	}
}
