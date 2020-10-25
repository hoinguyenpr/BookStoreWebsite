package com.bookstore.dao;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Category;

public class CategoryDAOTest {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void setupClass() {
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
		
		categoryDAO = new CategoryDAO(entityManager);
	}
	
	@Test
	public void testCreateCategory() {
		Category newCat = new Category("Health");
		Category category = categoryDAO.create(newCat);
		 System.out.println(category.toString());
		assertTrue(category != null && category.getCategoryId() > 0);
		
	}
	
	@Test
	public void deleteCategory() {
		categoryDAO.delete(25);
		Category check = categoryDAO.get(25);
		assertNull(check);
	}
	
	@AfterClass
	public static void tearDownClass() {
		entityManager.close();
		entityManagerFactory.close();
	}
}
