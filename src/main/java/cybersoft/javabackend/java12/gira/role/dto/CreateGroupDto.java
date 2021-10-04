package cybersoft.javabackend.java12.gira.role.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import cybersoft.javabackend.java12.gira.role.validation.annotation.UniqueGroupName;
import cybersoft.javabackend.java12.gira.role.validation.annotation.ValidGroupDescription;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateGroupDto {

	@NotBlank(message = "{group.name.not-blank}")
	@Size(min = 3, max = 50, message = "{group.name.size}")
	@UniqueGroupName(message = "{group.name.used}")
	private String name;

	@ValidGroupDescription
	private String description;

}
