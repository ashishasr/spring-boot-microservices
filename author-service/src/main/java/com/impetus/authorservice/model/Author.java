package com.impetus.authorservice.model;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="author")
public class Author {
	
	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)*/
	private long id;
	
	
	private String name;
	
	public Author(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/*@ElementCollection
	private List<Book> bookList = new ArrayList<Book>();
*/
	public Author() {
		super();
	}

	/*public Author(long id, String name, List<Book> bookList) {
		super();
		this.id = id;
		this.name = name;
		this.bookList = bookList;
	}*/

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + "]";
	}

	/*public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}*/
	
	
	
	
	/*private List<Book> bookList = new ArrayList<>();
	
	public void addBook(Book book) {
		bookList.add(book);
	}*/
	
	
	
	
}
