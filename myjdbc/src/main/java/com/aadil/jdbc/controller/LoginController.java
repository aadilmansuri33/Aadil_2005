package com.aadil.jdbc.controller;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aadil.jdbc.config.DBConfig;
import com.aadil.jdbc.dao.UserDao;
import com.aadil.jdbc.daoImpl.UserDaoImpl;
import com.aadil.jdbc.model.UserModel;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDao userDao = new UserDaoImpl();
	UserModel userModel = new UserModel();
	Properties properties = new Properties();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		properties.load(DBConfig.class.getClassLoader().getResourceAsStream("status.properties"));
		if (("logout").equals(request.getParameter("action"))) {
			request.removeAttribute("Login");
			request.getSession().invalidate();
			request.setAttribute("logout", properties.getProperty("logout"));
			request.getRequestDispatcher("UserLogin.jsp").forward(request, response);
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
			if ((userModel1 != null) && (userModel1.getPassword().equals(request.getParameter("password")))) {
				request.getSession().setAttribute("Login", userModel1);
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
