package com.mpattt.app.user;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class UserRegisterForm {
	@NotEmpty
	public String name;
	@NotEmpty
	public String email;
	@NotEmpty
	public String password;
}
