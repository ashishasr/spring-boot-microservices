package com.impetus.bookservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impetus.bookservice.model.Book;
import com.impetus.bookservice.services.IBookStoreService;

@RestController
@RequestMapping("/api/bookservice")
public class BookStoreController {
	
	@Autowired
	private IBookStoreService bookStoreService;
	
	@GetMapping("books")
	public ResponseEntity<List<Book>> getBooks(){
		List<Book> books = bookStoreService.getBooks();
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}
	
	@GetMapping("books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id")Integer id){
		Book book = bookStoreService.getBook(id);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
	
	@PostMapping("books")
	public ResponseEntity<Book> createBook(@RequestBody Book book){
		Book b = bookStoreService.createBook(book);
		return new ResponseEntity<Book>(b, HttpStatus.OK);
		
	}
	
	@PutMapping("books/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable("id") int id, @RequestBody Book book){
		
		Book b = bookStoreService.updateBook(id, book);
		return new ResponseEntity<Book>(b, HttpStatus.OK);
	}
	
	@DeleteMapping("books/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id") int id){
		boolean isDeleted = bookStoreService.deleteBook(id);
		if(isDeleted) {
			String msg = "Book has been deleted successfully";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}
		String error = "Error while deleting book from database";
		return new ResponseEntity<String>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		
		
	}

}
