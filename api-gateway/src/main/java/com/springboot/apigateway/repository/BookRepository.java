package com.springboot.apigateway.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.apigateway.dto.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	public Book findByBookId(long bookId);
}
