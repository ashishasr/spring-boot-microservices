package com.impetus.bookservice.services;

import java.util.List;

import com.impetus.bookservice.model.Book;

public interface IBookStoreService {

	List<Book> getBooks();
	
	Book getBook(int bookId);
	
	Book createBook(Book book);
	
	Book updateBook(int bookId, Book book);
	boolean deleteBook(int bookId);
}
