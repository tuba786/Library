package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Book;
import com.example.demo.repositories.BookRepo;
import com.example.demo.services.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired private BookRepo bookRepo;

	
	public List<Book> getBookList() {
		
		List<Book>list= bookRepo.findAll();
		return list;
	}
    public void createbook(Book b) {
		bookRepo.save(b);
		
	}
	

}
