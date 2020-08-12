package com.impetus.bookservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="book")
public class Book implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name= "id")
	private int id;
	
	@Column(name= "name")
	private String name;
	
	/*@Column(name ="author")
	private String author;*/
	
	@Column(name = "author_id")
	private long author_id;
	
	@Column(name ="category")
	private String category;
	
	@Column(name ="price")
	private int price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(long author_id) {
		this.author_id = author_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/*public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
*/
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
