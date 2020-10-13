package com.bookstore.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;

public class JpaDAO<E> {
	protected EntityManager entityManager;
	
	public JpaDAO(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	public E create(E entity) {
		entityManager.getTransaction().begin();
		
		entityManager.persist(entity);
		entityManager.flush();
		entityManager.refresh(entity);
		
		entityManager.getTransaction().commit();
		
		return entity;
	}
	
	public E update(E entity) {
		entityManager.getTransaction().begin();
		
		entityManager.merge(entity);
		
		entityManager.getTransaction().commit();
		
		return entity;
	}
	
	public void delete(Class<E> type, Object id) {
		entityManager.getTransaction().begin();
		
		Object reference =  entityManager.getReference(type, id);
		entityManager.remove(reference);
		
		entityManager.getTransaction().commit();
	}
	
	//find() method not change the database so don't getTransaction.
	public E find(Class<E> type , Object id) {
		E entity = entityManager.find(type, id);
		if(entity != null) {
			entityManager.refresh(entity);
		}
		return entity;
	}
	
	public List<E> findWithNamedQuery(String queryName, String paraName, Object paraValue){
		
		Query query = entityManager.createNamedQuery(queryName);
		
		query.setParameter(paraName, paraValue);
		
		return query.getResultList();
	}
	
	public List<E> findWithNamedQuery(String queryName){
		Query query = entityManager.createNamedQuery(queryName);
		return query.getResultList();	
	}
	
	public long countWithNamedQuery(String queryName) {
		Query query = entityManager.createNamedQuery(queryName);
		return (long) query.getSingleResult();
	}
}
