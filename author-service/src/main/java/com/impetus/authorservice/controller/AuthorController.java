package com.impetus.authorservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.impetus.authorservice.model.BookSummary;
import com.impetus.authorservice.model.CatalogItem;
import com.impetus.authorservice.services.AuthorRepository;
import com.impetus.authorservice.services.BookSummaryInfo;
import com.impetus.authorservice.services.GenreInfo;

@RestController
@RequestMapping("/api/authorservice/")
public class AuthorController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private AuthorRepository repository;
	
	@Autowired
	BookSummaryInfo bookSummaryInfo;
	
	@Autowired
	GenreInfo genreInfo;
	
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
	public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
		return new ResponseEntity<>(repository.save(author), HttpStatus.OK);
	}
	
	
	@DeleteMapping("/authors/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable(value ="id")Long authorId) throws ResourceNotFoundException{
		Author author = repository.findById(authorId).orElseThrow(() -> new ResourceNotFoundException("Author not found for this id ::" + authorId));
		repository.delete(author);
		return new ResponseEntity<String>("Author has been deleted succesfully", HttpStatus.OK);
	}
	
	@GetMapping("/authors/{id}/books")
	public ResponseEntity<List<CatalogItem>> getAuthorBooksById(@PathVariable(value = "id") Long authorId)
			throws ResourceNotFoundException {
		Author author = repository.findById(authorId)
				.orElseThrow(() -> new ResourceNotFoundException("Author not found for this id ::" + authorId));
		// List<Book> books= author.getBookList();
		BookSummary bookSummary = bookSummaryInfo.getBookSummary(authorId);
		List<CatalogItem> catalogItems = bookSummary.getBookList().stream().map(book -> genreInfo.getGenre(book))
				.collect(Collectors.toList());
		// bookSummary.setAutherName(author.getName());
		System.out.println("catalogItems--------- " + catalogItems);
		return ResponseEntity.ok().body(catalogItems);
	}
	
}
