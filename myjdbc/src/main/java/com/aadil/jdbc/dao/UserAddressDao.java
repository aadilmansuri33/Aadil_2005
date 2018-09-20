package com.aadil.jdbc.dao;

import java.util.List;

import com.aadil.jdbc.model.UserAddressModel;

public interface UserAddressDao {

	void saveAddress(UserAddressModel addressModel);

	void updateAddress(UserAddressModel addressModel);

	List<UserAddressModel> showAllAddress();
	
}
