package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.BookCategory;
import com.example.demo.repositories.BookCategoryRepo;
import com.example.demo.services.BookCategoryService;

@Service
public class BookCategoryServiceImpl implements BookCategoryService{

	@Autowired private BookCategoryRepo bookCategoryRepo;
	public List<BookCategory> getCategoryList() {
		List<BookCategory> list=bookCategoryRepo.findAll();
		return list;
	}
	
	public void createPublisher(BookCategory cat) {
		bookCategoryRepo.save(cat);
		
	}

	public BookCategory getBookCategory(int cid) {
		
		return bookCategoryRepo.findById(cid).orElse(null);
	}


	public void updateCategory(BookCategory bookCategory) {
		bookCategoryRepo.save(bookCategory);
		
	}

	
	public void removebyId(int cid) {
		bookCategoryRepo.deleteById(cid);
	}

}
