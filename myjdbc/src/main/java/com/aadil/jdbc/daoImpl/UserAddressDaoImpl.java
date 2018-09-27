package com.aadil.jdbc.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aadil.jdbc.config.DBConfig;
import com.aadil.jdbc.dao.UserAddressDao;
import com.aadil.jdbc.model.UserAddressModel;

public class UserAddressDaoImpl implements UserAddressDao {
	PreparedStatement statement;
	ResultSet resultSet;

	@Override
	public void saveAddress(UserAddressModel addressModel) {
		// TODO Auto-generated method stub
		try {
			String query = "insert into address_table (line,street,area,landmark,city,state,country,create_at,user_id) values(?,?,?,?,?,?,?,now(),?)";
			statement = DBConfig.getConnection().prepareStatement(query);
			statement.setString(1, addressModel.getLine());
			statement.setString(2, addressModel.getStreet());
			statement.setString(3, addressModel.getArea());
			statement.setString(4, addressModel.getLandmark());
			statement.setString(5, addressModel.getCity());
			statement.setString(6, addressModel.getState());
			statement.setString(7, addressModel.getCountry());
			statement.setLong(8, addressModel.getUserId());
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
	public void updateAddress(UserAddressModel addressModel) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<UserAddressModel> showAllAddress() {
		// TODO Auto-generated method stub
		List<UserAddressModel> addressModels = new ArrayList<>();
		try {
			statement = DBConfig.getConnection().prepareStatement("select * from address_table");
			resultSet = statement.executeQuery();
			UserAddressModel addressModel;
			while (resultSet.next()) {
				addressModel = extractUserAddressFromResultSet(resultSet);
				addressModels.add(addressModel);
			}

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
		return addressModels;
	}

	@Override
	public List<UserAddressModel> findAllAddressOfuser(Long userid) {
		// TODO Auto-generated method stub
		List<UserAddressModel> models = new ArrayList<>();
		UserAddressModel addressModel;
		try {
			statement = DBConfig.getConnection()
					.prepareStatement("select * from address_table where user_id=" + userid);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				addressModel = extractUserAddressFromResultSet(resultSet);
				models.add(addressModel);
			}

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
		return models;
	}

	@Override
	public UserAddressModel extractUserAddressFromResultSet(ResultSet resultSet) {
		// TODO Auto-generated method stub
		UserAddressModel addressModel = new UserAddressModel();
		try {
			addressModel.setAddressId(resultSet.getLong(1));
			addressModel.setLine(resultSet.getString(2));
			addressModel.setStreet(resultSet.getString(3));
			addressModel.setArea(resultSet.getString(4));
			addressModel.setLandmark(resultSet.getString(5));
			addressModel.setCity(resultSet.getString(6));
			addressModel.setState(resultSet.getString(7));
			addressModel.setCountry(resultSet.getString(8));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return addressModel;
	}

}
