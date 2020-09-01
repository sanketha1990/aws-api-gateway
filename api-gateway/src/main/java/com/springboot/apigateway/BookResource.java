package com.springboot.apigateway;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.apigateway.dto.Book;
import com.springboot.apigateway.service.BookService;

@RestController
@RequestMapping("/book")
public class BookResource {

	@Autowired
	private BookService service;

	@GetMapping("/{bookId}")
	public Book getBookById(@PathVariable("bookId") long bookId) {
		return service.getById(bookId);
	}

	@GetMapping("/all")
	public List<Book> getAllBooks() {
		return service.getAllBooks();
	}

	@PostMapping("/save")
	public Book save(@RequestBody Book book) {
		return service.save(book);
	}

	@PatchMapping("/update")
	public Book update(@RequestBody Book book) {
		return service.update(book);
	}

	@DeleteMapping("/delete/{bookId}")
	public void delete(@PathVariable("bookId") long bookId) {
		service.delete(bookId);
	}
}
