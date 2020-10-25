package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Category;

public class CategoryServices {
	private EntityManager entityManager;
	private CategoryDAO categoryDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public CategoryServices(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.entityManager = entityManager;
		
		categoryDAO = new CategoryDAO(entityManager);
	}
	
	public void listCategory() throws ServletException, IOException {
		listCategory(null);
	}
	
	public void listCategory(String message) throws ServletException, IOException {
		List<Category> listCategory = categoryDAO.listAll();
		
		request.setAttribute("listCategory", listCategory);
		
		if(message != null) {
			request.setAttribute("message", message);
		}
		
		String listPage = "category_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
		requestDispatcher.forward(request, response);
	}
	
	public void createCategory() throws ServletException, IOException {
		String categoryName = request.getParameter("name");
		
		Category existCategory = categoryDAO.findByName(categoryName);
		
		if(existCategory != null) {
			String message = "Create category fail, category with name " + categoryName + " already exists.";
			request.setAttribute("message", message);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("category_form.jsp");
			requestDispatcher.forward(request, response);
		}else {
			Category newCategory = new Category(categoryName);
			categoryDAO.create(newCategory);
			listCategory("New category created successfully");
		}
	}
	
	public void editCategory() throws ServletException, IOException {
		int categoryID = Integer.parseInt(request.getParameter("id"));
		
		Category editCategory = categoryDAO.get(categoryID);
		
		if(editCategory != null) {
			request.setAttribute("category", editCategory);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("category_form.jsp");
			requestDispatcher.forward(request, response);
		}else {
			String message = "Can't edit this user, this user not found in system";
			listCategory(message);
		}
	}
	
	public void updateCategory() throws ServletException, IOException {
		int categoryID = Integer.parseInt(request.getParameter("categoryId"));
		String categoryName = request.getParameter("name");
		
		Category enterCategory = categoryDAO.findByName(categoryName);
		Category thisCategory = categoryDAO.get(categoryID);
		
		if(enterCategory != null && enterCategory != thisCategory) {
			String message = "Edit faild! Category " + categoryName + " already exist in website";
			request.setAttribute("message", message);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("category_form.jsp");
			requestDispatcher.forward(request, response);
		}else {
			Category updateCategory = new Category(categoryID, categoryName);
			categoryDAO.update(updateCategory);
			String message = "Category has been update successfully";
			listCategory(message);
		}
	}
	
	public void deleteCategory() throws ServletException, IOException {
		int categoryID = Integer.parseInt(request.getParameter("id"));
		
		Category category = categoryDAO.get(categoryID);
		if(category == null) {
			String message = "Could not find category with ID " + categoryID + " , or it might have been deleted";
			listCategory(message);
		}else {
			categoryDAO.delete(categoryID);
			String message = "Delete category ID " +categoryID + " successfully!";
			listCategory(message);
		}
	}
}
