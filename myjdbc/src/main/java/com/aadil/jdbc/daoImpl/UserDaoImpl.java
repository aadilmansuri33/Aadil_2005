package com.aadil.jdbc.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.aadil.jdbc.config.DBConfig;
import com.aadil.jdbc.dao.UserDao;
import com.aadil.jdbc.model.UserModel;

public class UserDaoImpl implements UserDao {

	@Override
	public Long saveUser(UserModel userModel) {
		// TODO Auto-generated method stub
		Long userId = null;
		try {
			String query = "insert into user_table (role_id,suffix,first_name,last_name,email,date_of_birth,mobile_no,alternate_no,gender,password,create_at,file_id) values(?,?,?,?,?,?,?,?,?,?,now(),?)";
			PreparedStatement statement = DBConfig.getConnection().prepareStatement(query,
					PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setLong(1, userModel.getRoleId());
			statement.setString(2, userModel.getSuffix());
			statement.setString(3, userModel.getFirstName());
			statement.setString(4, userModel.getLastName());
			statement.setString(5, userModel.getEmail());
			statement.setString(6, userModel.getDateOfBirth());
			statement.setLong(7, userModel.getMobileNo());
			statement.setLong(8, userModel.getAlternateNo());
			statement.setString(9, userModel.getGender());
			statement.setString(10, userModel.getPassword());
			statement.setLong(11, userModel.getFileId());
			statement.executeUpdate();
			ResultSet resultSet = statement.getGeneratedKeys();
			while (resultSet.next()) {
				userId = resultSet.getLong(1);
			}
			statement.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userId;
	}

	@Override
	public void updateUser(UserModel userModel) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement statement = DBConfig.getConnection().prepareStatement(
					"update user_table set role_id = ? suffix = ?,first_name=?,last_name=?,email=?,date_of_birth=?,mobile_no=?,alternate_no=?,gender=?,update_at=now() where user_id = ? ");
			statement.setLong(1, userModel.getRoleId());
			statement.setString(2, userModel.getSuffix());
			statement.setString(3, userModel.getFirstName());
			statement.setString(4, userModel.getLastName());
			statement.setString(5, userModel.getEmail());
			statement.setString(6, userModel.getDateOfBirth());
			statement.setLong(7, userModel.getMobileNo());
			statement.setLong(8, userModel.getAlternateNo());
			statement.setString(9, userModel.getGender());
			statement.executeUpdate();
			statement.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public List<UserModel> showAllUser() {
		// TODO Auto-generated method stub
		List<UserModel> userModels = new ArrayList<>();
		UserModel userModel;
		try {
			PreparedStatement statement = DBConfig.getConnection().prepareStatement("select * from user_table");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				userModel = new UserModel();
				userModel.setUserId(resultSet.getLong(1));
				userModel.setRoleId(resultSet.getLong(2));
				userModel.setSuffix(resultSet.getString(3));
				userModel.setFirstName(resultSet.getString(4));
				userModel.setLastName(resultSet.getString(5));
				userModel.setEmail(resultSet.getString(6));
				userModel.setDateOfBirth(resultSet.getString(7));
				userModel.setMobileNo(resultSet.getLong(8));
				userModel.setAlternateNo(resultSet.getLong(9));
				userModel.setGender(resultSet.getString(10));
				userModel.setPassword(resultSet.getString(11));
				userModel.setCreateAt(resultSet.getString(12));
				userModel.setUpdateAt(resultSet.getString(13));
				userModel.setFileId(resultSet.getLong(14));
				userModels.add(userModel);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return userModels;
	}

	@Override
	public UserModel findByEmail(String email) {
		// TODO Auto-generated method stub
		UserModel userModel = null;
		try {
			String query = "select * from user_table where email = '" + email + "'";
			PreparedStatement statement = DBConfig.getConnection().prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				userModel = new UserModel();
				userModel.setUserId(resultSet.getLong("user_id"));
				userModel.setRoleId(resultSet.getLong("role_id"));
				userModel.setSuffix(resultSet.getString("suffix"));
				userModel.setFirstName(resultSet.getString("first_name"));
				userModel.setLastName(resultSet.getString("last_name"));
				userModel.setEmail(resultSet.getString("email"));
				userModel.setDateOfBirth(resultSet.getString("date_of_birth"));
				userModel.setMobileNo(resultSet.getLong("mobile_no"));
				userModel.setAlternateNo(resultSet.getLong("alternate_no"));
				userModel.setGender(resultSet.getString("gender"));
				userModel.setPassword(resultSet.getString("password"));
				userModel.setFileId(resultSet.getLong("file_id"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return userModel;
	}

	@Override
	public void deleteUser(Long userid) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement statement = DBConfig.getConnection()
					.prepareStatement("delete from user_table where user_id=" + userid);
			statement.executeUpdate();
			statement.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
