package com.project.forex.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.forex.Entity.UserManagmentEntity;
import com.project.forex.Exception.UserAlreadyExistsException;
import com.project.forex.Exception.UserNotFoundException;
import com.project.forex.Service.UserManagmentService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/")
public class UserManagmentController {
	
	@Autowired
	UserManagmentService userManagmentService;
	
	@GetMapping("/get-all-users")
	public List<UserManagmentEntity> getAllUsers(){
		return userManagmentService.getAllUsers();
	}
	
	@GetMapping("/get-user/{email}")
	public UserManagmentEntity getUser(@Valid @Email @PathVariable String email) throws UserNotFoundException{
		return userManagmentService.getUser(email);
	}
	
	@PostMapping("/register")
	public UserManagmentEntity addUser(@Valid @RequestBody UserManagmentEntity  userManagmentEntity) throws UserAlreadyExistsException {
		return userManagmentService.addUser(userManagmentEntity);
	}
	
	@DeleteMapping("/delete-user/{email}")
	public UserManagmentEntity deleteUser(@Valid @Email @PathVariable String email) throws UserNotFoundException {
		return userManagmentService.deleteUser(email);
	}
	
	@PutMapping("update-user")
	public UserManagmentEntity updateUser(@Valid @RequestBody UserManagmentEntity  userManagmentEntity) throws UserNotFoundException {
		return userManagmentService.updateUser(userManagmentEntity);
	}
}
