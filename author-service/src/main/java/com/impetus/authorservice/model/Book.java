package com.impetus.authorservice.model;

public class Book {

	private int id;

	private String name;

	private long author_id;

	private double price;
	

	public Book() {
		
	}
	
	public Book(int id, String name, long author_id, double price) {
		this.id = id;
		this.name = name;
		this.author_id = author_id;
		this.price = price;
	}
	

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}



}
