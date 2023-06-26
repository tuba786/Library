package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.BookPublisher;

public interface BookPublisherService {

	List<BookPublisher> getPublisherList();

	void createPublisher(BookPublisher bookPub);

	

	BookPublisher getBookPublisher(int pid);

	void updatePublisher(BookPublisher bookPub);

	void removebyId(int pid);

}
