package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Book;

public interface BookService {

	List<Book> getBookList();

	void createbook(Book b);

	



}
