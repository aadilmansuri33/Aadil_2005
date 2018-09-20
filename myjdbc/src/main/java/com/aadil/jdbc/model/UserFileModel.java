package com.aadil.jdbc.model;

import java.io.InputStream;

public class UserFileModel {

	private Long fileId;
	private InputStream uploadfile;
	private String createAt;
	private String updateAt;
	private String fileString;

	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	public InputStream getUploadfile() {
		return uploadfile;
	}

	public void setUploadfile(InputStream uploadfile) {
		this.uploadfile = uploadfile;
	}

	public String getCreateAt() {
		return createAt;
	}

	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}

	public String getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(String updateAt) {
		this.updateAt = updateAt;
	}

	public String getFileString() {
		return fileString;
	}

	public void setFileString(String fileString) {
		this.fileString = fileString;
	}

}
