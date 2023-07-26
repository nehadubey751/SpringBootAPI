package com.example.demo.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.entities.Book;

@Component
public class BookServices {

	private static  List<Book> list= new ArrayList();
	
	static {
		list.add(new Book(12341,"java book","xyz"));
		list.add(new Book(2323451,"sql book","pqr"));
		list.add(new Book(1523415,"html book","wxy"));
		}
	
	//get all book
	public List<Book> GetAllBooks() {
		return list;
	}
	
	//get id by book
      public Book getBookById(int id) {
    	  Book book=null;
    	 book= list.stream().filter(e->e.getId()==id).findFirst().get();
		return book;
    	  
      }
     // Adding the book
      public Book addBook(Book b) {
    	  list.add(b);
		return b;
    	  
      }
      
      //Delete book
      public void deleteBook(int bId) {
    	  list=list.stream().filter(book ->book.getId()!=bId).collect(Collectors.toList());
      }
      
     // update book
      public void updateBook(Book book,int bookId) {
    	  list =list.stream().map(b->{
    		  if(b.getId()==bookId)
    		  {
    			  b.setTitle(book.getTitle());
    			  b.setAuther(book.getAuther());
              }
    		  return b;
    		  
    	  }).collect(Collectors.toList());
      
      
}}




