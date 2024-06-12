package com.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	private Long id;
	private String name;
	private String email;
	private String gender;
	private int age;
	private String phoneNumber;
	private String occupation;
	private String qualification;

}
