package com.bookstore.entity;
// Generated 25 Aug, 2020 8:32:29 AM by Hibernate Tools 5.2.12.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Category generated by hbm2java
 */
@Entity
@Table(name = "category", catalog = "bookstoredb")
@NamedQueries({
	@NamedQuery(name = "Category.findAll", query = "SELECT u FROM Category u ORDER BY u.name"),
	@NamedQuery(name = "Category.countAll", query = "SELECT COUNT(*) from Category u"),
	@NamedQuery(name = "Category.findByName", query = "SELECT u FROM Category u WHERE u.name = :name")
 })
public class Category implements java.io.Serializable {

	private int categoryId;
	private String name;
	private Set<Book> books = new HashSet<Book>(0);

	public Category() {
	}
	
	public Category(String name) {
		this.name = name;
	}
	
	public Category(int categoryId, String name) {
		this.categoryId = categoryId;
		this.name = name;
	}

	public Category(int categoryId, String name, Set<Book> books) {
		this.categoryId = categoryId;
		this.name = name;
		this.books = books;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "category_id", unique = true, nullable = false)
	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "name", nullable = false, length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	public Set<Book> getBooks() {
		return this.books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", name=" + name + ", books=" + books + "]";
	}
	
	

}
