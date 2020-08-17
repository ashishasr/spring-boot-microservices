package com.impetus.genreservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "genre")
public class Genre {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name= "id")
	private long id;
	
	@Column(name= "category")
	private String category;
	
	@Column(name= "book_id")
	private long bookId;

	
	
	public Genre() {
		super();
	}



	public Genre(String category, long bookId) {
		super();
		this.category = category;
		this.bookId = bookId;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public long getBookId() {
		return bookId;
	}



	public void setBookId(long bookId) {
		this.bookId = bookId;
	}



	
	
	
}
