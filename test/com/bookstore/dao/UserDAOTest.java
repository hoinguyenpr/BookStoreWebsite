package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Users;

public class UserDAOTest {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static UserDAO userDAO;

	@BeforeClass
	public static void setupClass() {
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();

		userDAO = new UserDAO(entityManager);
	}

	@Test
	public void testCreateUsers() {
		Users newUser = new Users();
		newUser.setEmail("congml@gmail.com");
		newUser.setFullName("Nguyen Cong");
		newUser.setPassword("123cong");

		newUser = userDAO.create(newUser);

		assertTrue(newUser.getUserId() > 0);
	}

	@Test(expected = PersistenceException.class)
	public void testCreateUsersFieldNotSet() {
		Users newUser = new Users();

		newUser = userDAO.create(newUser);

	}

	@Test
	public void testUpdateUsers() {
		Users newUser = new Users();
		newUser.setUserId(25);
		newUser.setEmail("1nganml@gmail.com");
		newUser.setFullName("1Nguyen Ngan");
		newUser.setPassword("1123ngan");

		newUser = userDAO.update(newUser);
		String expected = "1123ngan";
		String actual = newUser.getPassword();

		assertEquals(expected, actual);
	}

	@Test
	public void testGetUsersFound() {
		Integer userID = 1;
		Users users = userDAO.get(userID);
		System.out.println(users.toString());
		assertNotNull(users);
	}

	@Test
	public void testGetUsersNotFoud() {
		Integer userID = 3;
		Users users = userDAO.get(userID);
		assertNull(users);
	}

	@Test
	public void testDeleteUser() {
		Integer userID = 25;
		userDAO.delete(userID);

		Users users = userDAO.get(userID);

		assertNull(users);
	}

	@Test(expected = EntityNotFoundException.class)
	public void testDeleteNonExistUser() {
		Integer userID = 25;
		userDAO.delete(userID);
	}
	
	@Test
	public void testListAll() {
		List<Users> listUsers = userDAO.listAll();
		assertTrue(listUsers.size() > 0);
	}
	
	@Test
	public void testCountAll() {
		long count = userDAO.count();
		System.out.println("Count ne " + count);
		assertEquals(4, count);
	}
	
	@Test
	public void testFindByEmail() {
		Users list = userDAO.findByEmail("levanlo1997@gmail.com");
		assertNotNull(list);
	}
	
	@AfterClass
	public static void tearDownClass() {
		entityManager.close();
		entityManagerFactory.close();
	}
}
