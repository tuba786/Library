package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.BookCategory;

public interface BookCategoryService {

	List<BookCategory> getCategoryList();

	void createPublisher(BookCategory cat);

	BookCategory getBookCategory(int cid);

	void updateCategory(BookCategory bookCategory);

	void removebyId(int cid);

}
