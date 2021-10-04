package cybersoft.javabackend.java12.gira.role.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import cybersoft.javabackend.java12.gira.role.util.HttpMethods;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProgramDto {

	@NotBlank(message = "{program.name.not-blank}")
	@Size(min = 3, max = 50, message = "{program.name.size}")
	private String name;

	@NotNull
	private HttpMethods method;

	@NotBlank
	private String path;

}
