package com.springboot.apigateway.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.apigateway.dto.Book;
import com.springboot.apigateway.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookrepo;

	List<Book> bookList = null;

	public List<Book> getAllBooks() {
		bookList = new ArrayList<Book>();
		bookrepo.findAll().forEach(bookList::add);
		return bookList;
	}

	public Book getById(long bookId) {
		return bookrepo.findByBookId(bookId);
	}

	public Book save(Book book) {
		return bookrepo.save(book);
	}

	public Book update(Book book) {
		Book bookObj = bookrepo.findByBookId(book.getBookId());
		if (bookObj == null) {
			System.out.println("There is no book Id present !! Going to create new book record");
		} else {
			bookObj = null;
			bookObj = bookrepo.save(book);
		}
		return bookObj;
	}

	public void delete(long bookId) {
		bookrepo.deleteById(bookId);
	}

}
