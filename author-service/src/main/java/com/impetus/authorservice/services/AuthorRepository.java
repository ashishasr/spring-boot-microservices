package com.impetus.authorservice.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.impetus.authorservice.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

}
