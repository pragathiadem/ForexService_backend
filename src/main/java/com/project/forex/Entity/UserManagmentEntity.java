package com.project.forex.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Table(name="usermanagment")
@Entity
public class UserManagmentEntity {
	
	@Id
	@Email(message="please enter a valid email")
	private String email;
	
	@NotNull(message = "password cannot be null")
	private String password;

	
	@NotNull(message = "firstName cannot be null")
	private String firstName;
	
	@NotNull(message = "lastName cannot be null")
	private String lastName;
	
	@NotNull(message = "passportNo cannot be null")
	private String passportNo;
		
	@NotNull(message = "nation cannot be null")
	private String nation;
	
	@NotNull(message ="role cannot be null")
	private String role;
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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

	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public UserManagmentEntity(@Email(message = "please enter a valid email") String email, String password,
			 String firstName, String lastName, String passportNo, String nation,String role) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.passportNo = passportNo;
		this.nation = nation;
		this.role=role;
	}

	public UserManagmentEntity() {
		super();
	}

	@Override
	public String toString() {
		return "UserManagmentEntity [email=" + email + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", passportNo=" + passportNo + ", nation=" + nation + ", role=" + role
				+ "]";
	}	
	
}
