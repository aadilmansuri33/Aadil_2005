package com.aadil.jdbc.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aadil.jdbc.dao.UserAddressDao;
import com.aadil.jdbc.daoImpl.UserAddressDaoImpl;
import com.aadil.jdbc.model.UserAddressModel;

/**
 * Servlet implementation class test
 */
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserAddressModel addressModel = new UserAddressModel();
	UserAddressDao addressDao = new UserAddressDaoImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (("test").equals(request.getParameter("action"))) {
			List<UserAddressModel> map = addressDao
					.findAllAddressOfuser(Long.parseLong(request.getParameter("userid")));
			Map<String, String> addressModels = new HashMap<>();
			for (int key = 1; key <= map.toArray().length; key++) {
				UserAddressModel model = (UserAddressModel) map.toArray()[key];
			}
			/*
			 * for (UserAddressModel model : map.values()) { model.getLine();
			 * model.getArea(); }
			 */
			request.setAttribute("map", map);
			// request.setAttribute("map2", map.values());
			request.getRequestDispatcher("test.jsp").forward(request, response);
		}
	}

	/**
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
