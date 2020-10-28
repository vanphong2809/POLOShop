package com.phong.poloshop.dao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.phong.poloshop.dao.entities.UserEntity;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	@Procedure(procedureName = "sp_register")
	public void register(@Param("UserName") String userName, @Param("Password") String password,
			@Param("Email") String email, @Param("Address") String address, @Param("Phone") String phone);
//	@Procedure(procedureName = "sp_findUserByEmail")
	@Query(value = "select * from [USER] u where u.Email like :email", nativeQuery = true)
	public UserEntity findUserByEmail(@Param("email") String email);
	
	@Query(value = "select * from [USER] u where u.UserName like ?1", nativeQuery = true)
	//public UserEntity findUserByUserName(@Param("userName") String userName);
	UserEntity findUserByUserName(String userName);
	
	@Query(value="select p.PermissionName from [USER] u join USER_ROLE ur on u.UserId=ur.UserId " + 
			"join [ROLE] r on ur.RoleId=r.RoleId join ROLE_PERMISSION rp on rp.RoleId=r.RoleId " + 
			"join PERMISSION p on rp.PermissionId=p.PermissionId " + 
			"where u.UserId=:userId", nativeQuery = true)
	public List<String> getPermissionName(@Param("userId") int userId);
}
