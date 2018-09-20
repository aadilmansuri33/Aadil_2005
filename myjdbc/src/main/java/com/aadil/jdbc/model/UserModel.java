package com.aadil.jdbc.model;

public class UserModel {

	private Long userId;
	private Long roleId;
	private String suffix;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private Long mobileNo;
	private Long alternateNo;
	private String password;
	private String dateOfBirth;
	private String createAt;
	private String updateAt;
	private Long fileId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Long getAlternateNo() {
		return alternateNo;
	}

	public void setAlternateNo(Long alternateNo) {
		this.alternateNo = alternateNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
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

	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

}
