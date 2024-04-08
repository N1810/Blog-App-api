package com.neeraj.services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.neeraj.payloads.UserDto;

public interface UserService {
	
	UserDto CreateUser(UserDto user);
	
	UserDto updateUser(UserDto user,Integer userId);
	
	UserDto getUserById(Integer userId);
	
	List<UserDto> getAllUsers();
	
	void deleteUser(Integer userId);

}
