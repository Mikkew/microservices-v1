package com.mms.auth.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDto {
	
	private Integer id;
	private String username;
	private String password;
	
	public UserDto(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
}
