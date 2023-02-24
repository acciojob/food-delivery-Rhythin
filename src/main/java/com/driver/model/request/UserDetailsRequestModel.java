package com.driver.model.request;

import com.driver.shared.dto.UserDto;

public class UserDetailsRequestModel {

	private String firstName;
	private String lastName;
	private String email;
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserDto toUserDto(){
		UserDto userDto=new UserDto();

		userDto.setFirstName(firstName);
		userDto.setLastName(lastName);
		userDto.setEmail(email);

		return userDto;
	}
}
