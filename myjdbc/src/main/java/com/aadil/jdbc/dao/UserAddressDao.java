package com.aadil.jdbc.dao;

import java.sql.ResultSet;
import java.util.List;

import com.aadil.jdbc.model.UserAddressModel;

public interface UserAddressDao {

	void saveAddress(UserAddressModel addressModel);

	void updateAddress(UserAddressModel addressModel);

	List<UserAddressModel> showAllAddress();

	List<UserAddressModel> findAllAddressOfuser(Long userid);

	UserAddressModel extractUserAddressFromResultSet(ResultSet resultSet);
}
