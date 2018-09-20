package com.aadil.jdbc.dao;

import java.util.List;

import com.aadil.jdbc.model.UserModel;

public interface UserDao {

	Long saveUser(UserModel userModel);

	void updateUser(UserModel userModel);

	List<UserModel> showAllUser();

	UserModel findByEmail(String email);

	void deleteUser(Long userid);
}
