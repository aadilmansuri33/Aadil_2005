package com.aadil.jdbc.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.aadil.jdbc.config.DBConfig;
import com.aadil.jdbc.dao.UserAddressDao;
import com.aadil.jdbc.dao.UserDao;
import com.aadil.jdbc.model.UserAddressModel;
import com.aadil.jdbc.model.UserModel;

public class UserAddressDaoImpl implements UserAddressDao {

	UserDao userDao = new UserDaoImpl();
	UserModel userModel = new UserModel();

	@Override
	public void saveAddress(UserAddressModel addressModel) {
		// TODO Auto-generated method stub
		try {
			String query = "insert into address_table (line,street,area,landmark,city,state,country,create_at,user_id) values(?,?,?,?,?,?,?,now(),?)";
			PreparedStatement statement = DBConfig.getConnection().prepareStatement(query);
			statement.setString(1, addressModel.getLine());
			statement.setString(2, addressModel.getStreet());
			statement.setString(3, addressModel.getArea());
			statement.setString(4, addressModel.getLandmark());
			statement.setString(5, addressModel.getCity());
			statement.setString(6, addressModel.getState());
			statement.setString(7, addressModel.getCountry());
			statement.setLong(8, addressModel.getUserId());
			statement.executeUpdate();
			statement.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateAddress(UserAddressModel addressModel) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<UserAddressModel> showAllAddress() {
		// TODO Auto-generated method stub
		List<UserAddressModel> addressModels = new ArrayList<>();
		UserAddressModel addressModel;
		try {
			PreparedStatement statement = DBConfig.getConnection().prepareStatement("select * from address_table");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				addressModel = new UserAddressModel();
				addressModel.setAddressId(resultSet.getLong(1));
				addressModel.setLine(resultSet.getString(2));
				addressModel.setStreet(resultSet.getString(3));
				addressModel.setArea(resultSet.getString(4));
				addressModel.setLandmark(resultSet.getString(5));
				addressModel.setCity(resultSet.getString(6));
				addressModel.setState(resultSet.getString(7));
				addressModel.setCountry(resultSet.getString(8));
				addressModels.add(addressModel);
			}
			statement.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return addressModels;
	}

}
