package com.bookstore.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.bookstore.entity.Category;

public class CategoryDAO extends JpaDAO<Category> implements GenericDAO<Category>{

	public CategoryDAO(EntityManager entityManager) {
		super(entityManager);
		
	}
	
	public Category create(Category newCategory) {
		return super.create(newCategory);
	}
	
	public Category update(Category updateCategory) {
		return super.update(updateCategory);
	}
	
	@Override
	public Category get(Object categoryID) {
		return super.find(Category.class, categoryID);
	}

	@Override
	public void delete(Object categoryID) {
		super.delete(Category.class, categoryID);
	}

	@Override
	public List<Category> listAll() {
		return super.findWithNamedQuery("Category.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Category.countAll");
	}
	
	public Category findByName(String categoryName) {
		List<Category> categories = super.findWithNamedQuery("Category.findByName", "name", categoryName);
		
		if(categories != null && categories.size() > 0) {
			return categories.get(0);
		}
		
		return null;
	}
}
