package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Book;
import com.example.demo.services.BookServices;

@RestController
public class Controller {
	
	@Autowired
	private BookServices bookservice;
	
	@GetMapping("/Books")
	public List<Book> getbooks() {
		return this.bookservice.GetAllBooks();
		
	}
	
	@GetMapping("/Books/{id}")
	public Book getBook(@PathVariable("id")int id) {
		return bookservice.getBookById(id);
	}
	
	// new book hadler(create)
	@PostMapping("/Books")
	public Book addBook(@RequestBody Book book) {
		this.bookservice.addBook(book);
		System.out.println(book);
		return book;
	
	}
	
	//delete book handler
	@DeleteMapping("/Books/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId) {
		this.bookservice.deleteBook(bookId);
		
	}
	
	//update book handle
	@PutMapping("/Books/{bookId}")
	public Book updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId) {
		this.bookservice.updateBook(book,bookId);
		return book;
		
}
}

