package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.UserDAO;
import com.bookstore.entity.Users;

public class UserServices {
	private EntityManager entityManager;
	private UserDAO userDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public UserServices(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {

		this.request = request;
		this.response = response;
		this.entityManager = entityManager;


		userDAO = new UserDAO(entityManager);
	}

	// method with 2 parameter
	public void listUser() throws ServletException, IOException {
		listUser(null);
	}

	// method with 3 parameter ( send a message)
	public void listUser(String message) throws ServletException, IOException {

		List<Users> listUsers = userDAO.listAll();

		// send listUsers to JSP page
		request.setAttribute("listUsers", listUsers);

		if (message != null) {
			request.setAttribute("message", message);
		}

		String listPage = "user_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);

		requestDispatcher.forward(request, response);
	}

	public void createUser() throws ServletException, IOException {
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullname");
		String password = request.getParameter("password");

		Users existUser = userDAO.findByEmail(email);

		if (existUser != null) {

			String message = "Create new user faild, email " + email + " already exists.";
			request.setAttribute("message", message);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("user_form.jsp");
			requestDispatcher.forward(request, response);

		} else {
			Users newUser = new Users(email, password, fullName);
			userDAO.create(newUser);
			listUser("New user created successfully");
		}

	}

	public void editUser() throws ServletException, IOException {

		int userID = Integer.parseInt(request.getParameter("id"));
		Users user = userDAO.get(userID);

		String editPage = "user_form.jsp";
		
		if(user == null) {
			String errorMsg = "Could not find user with ID " + userID;
			request.setAttribute("message", errorMsg);
		}else {
			request.setAttribute("user", user);
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
		requestDispatcher.forward(request, response);
	}


	public void updateUser() throws ServletException, IOException { 
		int userID = Integer.parseInt(request.getParameter("userId"));
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullname");
		String password = request.getParameter("password");
		
		Users userById = userDAO.get(userID);
		Users userByEmail = userDAO.findByEmail(email);
		
		if(userByEmail != null && userByEmail.getUserId() != userById.getUserId()) {
			String message = "Could not update user";
			request.setAttribute("message", message);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("user_form.jsp");
			requestDispatcher.forward(request, response);
		}else {
			Users updateUser = new Users(userID, email, password, fullName);
			userDAO.update(updateUser);
			
			String message = "User has been updated sucessfully"; 
			listUser(message);
		}
	}
	
	public void deleteUser() throws ServletException, IOException {
		
		int userID = Integer.parseInt(request.getParameter("id"));
		if(userID == 1) {
			String message = "The default admin user account cannot be deleted";
			listUser(message);
		}else {
			Users user = userDAO.get(userID);
			if(user == null) {
				String message = "Could not find user with ID " + userID + ", or it might have been deleted by another admin.' Replace " + userID + " by the actual value.";
				listUser(message);
			}else {
				userDAO.delete(userID);
				String message = "Delete user success";
				listUser(message);
			}
		}

	}
	
	public void login() throws ServletException, IOException {
		String email = request.getParameter("email");
		String password =  request.getParameter("password");
		
		boolean result = userDAO.checkLogin(email, password);
		
		if(result) {
			request.getSession().setAttribute("useremail", email);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/");
			requestDispatcher.forward(request, response);
			
		}else {
			String message = "Login faild";
			request.setAttribute("message", message);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response);
		}
	}
	
}
