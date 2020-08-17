package com.impetus.authorservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.impetus.authorservice.model.Book;
import com.impetus.authorservice.model.CatalogItem;
import com.impetus.authorservice.model.Genre;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class GenreInfo {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getFallbackGenre")
	public CatalogItem getGenre(Book book) {
			Genre genre = restTemplate.getForObject("http://genre-catalog-service/api/genreservice/genres/" + book.getId(), Genre.class);
			return new CatalogItem(book.getId(), book.getName(), genre.getCategory(), book.getPrice());
	}
	
	public CatalogItem getFallbackGenre(Book book) {
		System.out.println("Call getFallbackGenre()---------");
		return new CatalogItem(book.getId(), book.getName(), "category not found", book.getPrice());
	}

}
