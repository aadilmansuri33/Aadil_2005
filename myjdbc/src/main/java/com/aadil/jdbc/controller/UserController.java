package com.aadil.jdbc.controller;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aadil.jdbc.dao.UserAddressDao;
import com.aadil.jdbc.dao.UserDao;
import com.aadil.jdbc.dao.UserFileDao;
import com.aadil.jdbc.daoImpl.UserAddressDaoImpl;
import com.aadil.jdbc.daoImpl.UserDaoImpl;
import com.aadil.jdbc.daoImpl.UserFileDaoImpl;
import com.aadil.jdbc.model.UserAddressModel;
import com.aadil.jdbc.model.UserFileModel;
import com.aadil.jdbc.model.UserModel;

/**
 * Servlet implementation class UserController
 */
@MultipartConfig(maxFileSize = 1024 * 1024 * 5)
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final UserModel userModel = new UserModel();
	static final UserDao userDao = new UserDaoImpl();
	static final UserAddressModel addressModel = new UserAddressModel();
	static final UserAddressDao addressDao = new UserAddressDaoImpl();
	static final UserFileModel fileModel = new UserFileModel();
	static final UserFileDao fileDao = new UserFileDaoImpl();
	static final Properties properties = new Properties();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		properties.load(UserController.class.getClassLoader().getResourceAsStream("status.properties"));
		if ("data".equals(request.getParameter("action"))) {
			List<UserModel> models = userDao.showAllUser();
			request.setAttribute("users", models);
			request.getRequestDispatcher("Users.jsp").forward(request, response);
		}
		if ("delete".equals(request.getParameter("action"))) {
			userDao.deleteUser(Long.parseLong(request.getParameter("userid")));
			request.setAttribute("deleteSuccess", properties.getProperty("deleteSuccess"));
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			request.setAttribute("deleteFailed", properties.getProperty("deleteFailed"));
			request.getRequestDispatcher("Users.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		properties.load(UserController.class.getClassLoader().getResourceAsStream("status.properties"));
		Long userid, fileId;
		fileModel.setUploadfile(request.getPart("upfile").getInputStream());
		fileId = fileDao.saveFile(fileModel);
		userModel.setUserRoleId(Long.parseLong("2"));
		userModel.setSuffix(request.getParameter("suffix"));
		userModel.setFirstName(request.getParameter("firstName"));
		userModel.setLastName(request.getParameter("lastName"));
		userModel.setEmail(request.getParameter("email"));
		userModel.setDateOfBirth(request.getParameter("dateOfBirth"));
		userModel.setMobileNo(Long.parseLong(request.getParameter("mobileNo")));
		userModel.setAlternateNo(Long.parseLong(request.getParameter("alternateNo")));
		userModel.setGender(request.getParameter("gender"));
		userModel.setPassword(request.getParameter("password"));
		userModel.setFileId(fileId);

		userid = userDao.saveUser(userModel);

		if (userid != null) {
			String line[] = request.getParameterValues("line[]");
			String street[] = request.getParameterValues("street[]");
			String area[] = request.getParameterValues("area[]");
			String landmark[] = request.getParameterValues("famous[]");
			String city[] = request.getParameterValues("city[]");
			String state[] = request.getParameterValues("state[]");
			String country[] = request.getParameterValues("country[]");

			for (int key = 0; key < line.length; key++) {
				addressModel.setUserId(userid);
				addressModel.setLine(line[key]);
				addressModel.setStreet(street[key]);
				addressModel.setArea(area[key]);
				addressModel.setLandmark(landmark[key]);
				addressModel.setCity(city[key]);
				addressModel.setState(state[key]);
				addressModel.setCountry(country[key]);
				addressDao.saveAddress(addressModel);
			}
			request.setAttribute("success", properties.getProperty("registrationSuccess"));
			request.getRequestDispatcher("UserLogin.jsp").forward(request, response);
		} else {
			request.setAttribute("failed", properties.getProperty("registrationFailed"));
			request.getRequestDispatcher("Registration.jsp").forward(request, response);
		}
	}

}
