package com.impetus.authorservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.impetus.authorservice.exception.ResourceNotFoundException;
import com.impetus.authorservice.model.Author;
import com.impetus.authorservice.model.Book;
import com.impetus.authorservice.model.BookInfo;
import com.impetus.authorservice.services.AuthorRepository;

@RestController
@RequestMapping("/api/authorservice/")
public class AuthorController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private AuthorRepository repository;
	
	@GetMapping("/authors")
	List<Author> getAllAuthors(){
		
		return repository.findAll();
	}
	
	@GetMapping("/authors/{id}")
	public ResponseEntity<Author> getAuthor(@PathVariable(value = "id") Long authorId) throws ResourceNotFoundException {
		Author author = repository.findById(authorId).orElseThrow(() -> new ResourceNotFoundException("Author not found for this id ::" + authorId));
		return ResponseEntity.ok().body(author);
	}
	
	@PostMapping("/authors")
	public Author createAuthor(@RequestBody Author author) {
		return repository.save(author);
	}
	
	
	@DeleteMapping("/authors/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable(value ="id")Long authorId) throws ResourceNotFoundException{
		Author author = repository.findById(authorId).orElseThrow(() -> new ResourceNotFoundException("Author not found for this id ::" + authorId));
		repository.delete(author);
		return new ResponseEntity<String>("Author has been deleted succesfully", HttpStatus.OK);
	}
	
	@GetMapping("/authors/{id}/books")
	public ResponseEntity<List<BookInfo>> getAuthorBooksById(@PathVariable(value = "id") Long authorId) throws ResourceNotFoundException{
		Author author = repository.findById(authorId).orElseThrow(() -> new ResourceNotFoundException("Author not found for this id ::" + authorId));
		//List<Book> books= author.getBookList();
		return null;
	}
	
}
