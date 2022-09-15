package com.project.forex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.forex.Entity.UserManagmentEntity;
import com.project.forex.Exception.UserAlreadyExistsException;
import com.project.forex.Exception.UserNotFoundException;
import com.project.forex.Service.UserManagmentService;

@ExtendWith(MockitoExtension.class)
class ForexApplicationTests {

	@Mock
	UserManagmentService userManagmentService;
	
	@Test
	void addUserTest() throws UserAlreadyExistsException {
		UserManagmentEntity userEntity = new UserManagmentEntity("asd@asd.com","pass","name","Lname","ta12rfas","Indian", null);
		when(userManagmentService.addUser(userEntity)).thenReturn(userEntity);
		assertEquals(userManagmentService.addUser(userEntity),userEntity);
	}
	@Test
	void updateUserTest() throws UserNotFoundException {
		UserManagmentEntity userEntity = new UserManagmentEntity("asd@asd.com","pass","Lname","ta12rfas",null, "Indian", null);
		when(userManagmentService.updateUser(userEntity)).thenReturn(userEntity);
		assertEquals(userManagmentService.updateUser(userEntity),userEntity);
	}
	@Test
	void deleteUserTest() throws UserNotFoundException {
		UserManagmentEntity userEntity = new UserManagmentEntity("asd@asd.com","pass","name","Lname","ta12rfas","Indian", null);
		when(userManagmentService.deleteUser("asd@asd.com")).thenReturn(userEntity);
		assertEquals(userManagmentService.deleteUser("asd@asd.com"),userEntity);
	}
	@Test
	void getUserTest() throws UserNotFoundException {
		UserManagmentEntity userEntity = new UserManagmentEntity("asd@asd.com","pass","name","Lname","ta12rfas","Indian", null);
		when(userManagmentService.getUser("asd@asd.com")).thenReturn(userEntity);
		assertEquals(userManagmentService.getUser("asd@asd.com"),userEntity);
	}
	
	

}
