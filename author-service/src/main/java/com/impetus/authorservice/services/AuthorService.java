package com.impetus.authorservice.services;

import java.util.List;

import com.impetus.authorservice.model.Author;

public interface AuthorService {
	Author findAuthorById(String id);
	
	List<Author> findALl();
	
	
}
