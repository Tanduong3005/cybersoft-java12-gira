package cybersoft.javabackend.java12.gira.user.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import cybersoft.javabackend.java12.gira.user.validation.annotation.ConfirmPassword;
import cybersoft.javabackend.java12.gira.user.validation.annotation.UniqueEmail;
import cybersoft.javabackend.java12.gira.user.validation.annotation.UniqueUsername;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfirmPassword
public class CreateUserDto {

	@NotBlank(message = "{user.username.not-blank}")
	@UniqueUsername
	private String username;

	@NotBlank(message = "{user.password.not-blank}")
	private String password;

	@NotBlank(message = "{user.confirm-password.not-blank}")
	private String confirmPassword;

	@NotBlank(message = "{user.email.not-blank}")
	@Email()
	@UniqueEmail
	private String email;

}
