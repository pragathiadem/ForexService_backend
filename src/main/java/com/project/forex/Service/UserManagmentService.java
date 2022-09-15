package com.project.forex.Service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.forex.Entity.UserManagmentEntity;
import com.project.forex.Exception.UserAlreadyExistsException;
import com.project.forex.Exception.UserNotFoundException;
import com.project.forex.Repository.UserManagmentRepo;

@Service
public class UserManagmentService {
	
	@Autowired
	UserManagmentRepo usermanagmentRepo;

	public List<UserManagmentEntity> getAllUsers() {
		
		return usermanagmentRepo.findAll();
	}

	public UserManagmentEntity getUser(@Valid @Email String email) throws UserNotFoundException {
		try {
			return usermanagmentRepo.findById(email).get();
		}
		catch(Exception e) {
			throw new UserNotFoundException("User Not Found");
		}
	}

	public UserManagmentEntity deleteUser(String email) throws UserNotFoundException{
		try {
			UserManagmentEntity user = usermanagmentRepo.findById(email).get();
			usermanagmentRepo.deleteById(email);
			return user;
		}
		catch(Exception e) {
			throw new UserNotFoundException("User Not Found");
		}
	}

	public UserManagmentEntity addUser(UserManagmentEntity userManagmentEntity) throws UserAlreadyExistsException {

		if(usermanagmentRepo.findById(userManagmentEntity.getEmail()).isPresent()) {

			throw new UserAlreadyExistsException("User already Found");
		}
		return usermanagmentRepo.save(userManagmentEntity);
	}

	public UserManagmentEntity updateUser(UserManagmentEntity userManagmentEntity)throws UserNotFoundException {
		
		try {
			UserManagmentEntity user = usermanagmentRepo.findById(userManagmentEntity.getEmail()).get();
			return usermanagmentRepo.save(userManagmentEntity);
		}
		catch(Exception e) {
			throw new UserNotFoundException("User Not Found");
		}
	}

}
