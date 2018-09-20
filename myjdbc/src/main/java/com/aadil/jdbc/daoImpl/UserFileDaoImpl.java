package com.aadil.jdbc.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.aadil.jdbc.config.DBConfig;
import com.aadil.jdbc.dao.UserFileDao;
import com.aadil.jdbc.model.UserFileModel;

public class UserFileDaoImpl implements UserFileDao {

	@Override
	public Long saveFile(UserFileModel fileModel) {
		// TODO Auto-generated method stub
		Long fileId = null;
		try {
			String query = "insert into file_table (file,create_at) values(?,now())";
			PreparedStatement statement = DBConfig.getConnection().prepareStatement(query,
					PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setBlob(1, fileModel.getUploadfile());
			statement.executeUpdate();
			ResultSet resultSet = statement.getGeneratedKeys();
			while (resultSet.next()) {
				fileId = resultSet.getLong(1);
			}
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileId;
	}

	@Override
	public Long updateFile(UserFileModel fileModel) {
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	public List<UserFileModel> showAllFiles() {
		// TODO Auto-generated method stub
		List<UserFileModel> fileModels = new ArrayList<>();
		UserFileModel fileModel;
		try {
			PreparedStatement statement = DBConfig.getConnection().prepareStatement("select * from file_table");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				fileModel = new UserFileModel();
				fileModel.setFileId(resultSet.getLong(1));
				fileModel.setFileString(Base64.getEncoder().encodeToString(resultSet.getBytes(2)));
				fileModel.setCreateAt(resultSet.getString(3));
				fileModel.setUpdateAt(resultSet.getString(4));
				fileModels.add(fileModel);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return fileModels;
	}

}
