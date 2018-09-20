package com.aadil.jdbc.dao;

import java.util.List;

import com.aadil.jdbc.model.UserFileModel;

public interface UserFileDao {

	Long saveFile(UserFileModel fileModel);

	Long updateFile(UserFileModel fileModel);

	List<UserFileModel> showAllFiles();

}
