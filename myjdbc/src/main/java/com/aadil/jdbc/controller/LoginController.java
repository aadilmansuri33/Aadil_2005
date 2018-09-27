package com.aadil.jdbc.controller;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.aadil.jdbc.config.DBConfig;
import com.aadil.jdbc.dao.UserDao;
import com.aadil.jdbc.daoImpl.UserDaoImpl;
import com.aadil.jdbc.model.UserModel;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static final UserDao userDao = new UserDaoImpl();
	static final UserModel userModel = new UserModel();
	static final Properties properties = new Properties();
	static Logger log = Logger.getLogger(LoginController.class.getName());

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		properties.load(DBConfig.class.getClassLoader().getResourceAsStream("status.properties"));
		if ("logout".equals(request.getParameter("action"))) {
			request.getSession().removeAttribute("Login");
			request.getSession().invalidate();
			log.info("Logout successful");
			request.setAttribute("logout", properties.getProperty("logout"));
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		properties.load(DBConfig.class.getClassLoader().getResourceAsStream("status.properties"));
		try {
			UserModel userModel1 = userDao.findByEmail(request.getParameter("email"));
			if (!userModel1.toString().isEmpty() && userModel1.getPassword().equals(request.getParameter("password"))) {
				request.getSession().setAttribute("Login", "Login");
				request.getSession().setAttribute("userId", userModel1.getUserId());
				request.getSession().setAttribute("userRoleId", userModel1.getUserRoleId());
				request.getSession().setAttribute("firstName", userModel1.getFirstName());
				request.getSession().setAttribute("lastName", userModel1.getLastName());
				request.getSession().setAttribute("email", userModel1.getEmail());
				request.getSession().setAttribute("suffix", userModel1.getSuffix());
				request.setAttribute("loginSucess", properties.getProperty("loginSucess"));
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				request.setAttribute("loginFailed", properties.getProperty("loginFailed"));
				request.getRequestDispatcher("UserLogin.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
