/*package com.impetus.authorservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.impetus.authorservice.model.Author;

@RestController
@RequestMapping("/api/author")
public class AuthorResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/{authorId}")
	public Author getAuthorId(String authorId) {
		return new Author(101, "Test");
	}
	
}
*/