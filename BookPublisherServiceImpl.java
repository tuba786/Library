package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.BookPublisher;
import com.example.demo.repositories.BookPublisherRepo;
import com.example.demo.services.BookPublisherService;

@Service
public class BookPublisherServiceImpl implements BookPublisherService {

	@Autowired 
	private BookPublisherRepo bookPublisherRepo;
	
	public List<BookPublisher> getPublisherList() {
		List<BookPublisher> list=bookPublisherRepo.findAll();
		return list;
	}

	
	public void createPublisher(BookPublisher bookPub) {
		bookPublisherRepo.save(bookPub);
		
	}
   public BookPublisher getBookPublisher(int pid) {
		
		return bookPublisherRepo.findById(pid).orElse(null) ;
	}

public void updatePublisher(BookPublisher bookPub) {
	
	bookPublisherRepo.save(bookPub);
     }



public void removebyId(int pid) {
	bookPublisherRepo.deleteById(pid);
	
}





}
