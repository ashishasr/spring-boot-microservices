package com.impetus.authorservice.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="author")
public class Author implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	/*@OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	//@JsonManagedReference("author")
	@JsonIgnore
	private List<Book> bookList = new ArrayList<Book>();*/

	public Author() {
		super();
	}

	public Author(String name) {
		super();
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	*/
	
	/*public void addBook(Book book) {
		bookList.add(book);
		//book.setAuthor(this);
	}*/
	
	
	
}
