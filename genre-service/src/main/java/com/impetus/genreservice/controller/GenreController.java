package com.impetus.genreservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impetus.genreservice.model.Genre;
import com.impetus.genreservice.repository.GenreRepository;

@RestController
@RequestMapping("api/genreservice")
public class GenreController {

	@Autowired
	private GenreRepository genreRepository;
	
	@GetMapping("/genres/{id}")
	public ResponseEntity<Genre> getGenreByBookId(@PathVariable(value ="id") Long bookId){
		Genre genre = genreRepository.findByBookId(bookId);
		return new ResponseEntity<Genre>(genre, HttpStatus.OK);
	}
}
