package cybersoft.javabackend.java12.gira.role.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import cybersoft.javabackend.java12.gira.role.validation.annotation.UniqueGroupName;
import cybersoft.javabackend.java12.gira.role.validation.annotation.ValidGroupDescription;

public class CreateGroupDto {
	
	@NotBlank(message = "{group.name.not-blank}")
	@Size(min = 3, max = 50, message = "{group.name.size}")
	@UniqueGroupName(message = "{group.name.used}")
	private String name;

	@ValidGroupDescription
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
