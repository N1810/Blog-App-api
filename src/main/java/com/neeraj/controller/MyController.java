package com.neeraj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neeraj.payloads.ApiResponse;
import com.neeraj.payloads.UserDto;
import com.neeraj.services.UserService;

@RestController
@RequestMapping("api/users")
public class MyController {

	@Autowired
	private UserService userService;

	// POST CREATE USER
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
		UserDto createUserDto = this.userService.CreateUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}

	// PUT - UPDATE USER
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userdto, @PathVariable Integer userId) {

		UserDto updatedUser = this.userService.updateUser(userdto, userId);
		return ResponseEntity.ok(updatedUser);

	}

	@DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer userId) {
        try {
            userService.deleteUser(userId);
            return new ResponseEntity<>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
        } catch (Exception e) {
            // Handle the exception and return an error response
            return new ResponseEntity<>(new ApiResponse("Failed to delete user: " + e.getMessage(), false), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	// GET USER GET
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers() {

		return ResponseEntity.ok(this.userService.getAllUsers());

	}

	// GET ONE USER

	public ResponseEntity<UserDto> getSingleUsers(@PathVariable Integer userId) {

		return ResponseEntity.ok(this.userService.getUserById(userId));

	}

}
