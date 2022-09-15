package com.project.forex.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.forex.Entity.UserManagmentEntity;


@Repository
public interface UserManagmentRepo extends JpaRepository<UserManagmentEntity,String>{

}
