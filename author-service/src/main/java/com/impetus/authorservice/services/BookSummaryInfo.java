package com.impetus.authorservice.services;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.impetus.authorservice.model.Book;
import com.impetus.authorservice.model.BookSummary;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class BookSummaryInfo {

	@Autowired
	private RestTemplate restTemplate;

	//Use separate threadpool for service methods
	@HystrixCommand(fallbackMethod = "getFallbackBookSummary")
	public BookSummary getBookSummary(Long authorId) {
		return restTemplate.getForObject("http://book-catalog-service/api/bookservice/authors/" + authorId, BookSummary.class);
	}
	
	public BookSummary getFallbackBookSummary(Long authorId) {
		System.out.println("Call fallback- getFallbackBookSummary()-------");
		BookSummary bookSummary = new BookSummary();
		bookSummary.setAuthorId(0);
		bookSummary.setBookList(Arrays.asList(new Book(0,"book not found", 0, 0.0)));
		return bookSummary;
	}
}
