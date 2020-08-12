package com.impetus.bookservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.bookservice.dao.BookStoreDAO.BookStoreDAO;
import com.impetus.bookservice.model.Book;

@Service
public class BookStoreService implements IBookStoreService{
	
	@Autowired
	private BookStoreDAO bookstoredao;

	@Override
	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		List<Book> books = bookstoredao.getBooks();
		return books;
	}

	@Override
	public Book createBook(Book book) {
		// TODO Auto-generated method stub
		return bookstoredao.createBook(book);
	}

	@Override
	public Book updateBook(int bookId, Book book) {
		// TODO Auto-generated method stub
		return bookstoredao.updateBook(bookId, book);
	}

	@Override
	public boolean deleteBook(int bookId) {
		// TODO Auto-generated method stub
		return bookstoredao.deleteBook(bookId);
	}

	@Override
	public Book getBook(int bookId) {
		// TODO Auto-generated method stub
		return bookstoredao.getBook(bookId);
	}

	@Override
	public List<Book> getBooks(Long authorId) {
		// TODO Auto-generated method stub
		return bookstoredao.getBooks(authorId);
	}
	
	
	
}
