package com.aadil.jdbc.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aadil.jdbc.config.DBConfig;
import com.aadil.jdbc.dao.UserDao;
import com.aadil.jdbc.model.UserModel;

public class UserDaoImpl implements UserDao {
	PreparedStatement statement;
	ResultSet resultSet;

	@Override
	public Long saveUser(UserModel userModel) {
		// TODO Auto-generated method stub
		Long userId = null;
		try {
			String query = "insert into user_table (role_id,suffix,first_name,last_name,email,date_of_birth,mobile_no,alternate_no,gender,password,create_at,file_id) values(?,?,?,?,?,?,?,?,?,?,now(),?)";
			statement = DBConfig.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setLong(1, userModel.getUserRoleId());
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
			resultSet = statement.getGeneratedKeys();
			while (resultSet.next()) {
				userId = resultSet.getLong(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return userId;
	}

	@Override
	public void updateUser(UserModel userModel) {
		// TODO Auto-generated method stub

		try {
			String query = "update user_table set role_id = ? suffix = ?,first_name=?,last_name=?,email=?,date_of_birth=?,mobile_no=?,alternate_no=?,gender=?,update_at=now() where user_id = ? ";
			statement = DBConfig.getConnection().prepareStatement(query);
			statement.setLong(1, userModel.getUserRoleId());
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
		} catch (Exception e) { // TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<UserModel> showAllUser() {
		// TODO Auto-generated method stub
		List<UserModel> userModels = new ArrayList<>();
		try {
			UserModel userModel;
			statement = DBConfig.getConnection().prepareStatement("select * from user_table");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				userModel = extractUserFromResultSet(resultSet);
				userModels.add(userModel);
			}
			resultSet.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return userModels;
	}

	@Override
	public UserModel findByEmail(String email) {
		// TODO Auto-generated method stub
		UserModel userModel = null;
		try {
			String query = "select * from user_table where email = ?";
			statement = DBConfig.getConnection().prepareStatement(query);
			statement.setString(1, email);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				userModel = new UserModel();
				userModel = extractUserFromResultSet(resultSet);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return userModel;
	}

	@Override
	public void deleteUser(Long userid) {
		// TODO Auto-generated method stub
		try {
			statement = DBConfig.getConnection().prepareStatement("delete from user_table where user_id=" + userid);
			statement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public UserModel extractUserFromResultSet(ResultSet resultSet) {
		// TODO Auto-generated method stub
		UserModel userModel = new UserModel();
		try {
			userModel.setUserId(resultSet.getLong(1));
			userModel.setUserRoleId(resultSet.getLong(2));
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userModel;
	}

}
