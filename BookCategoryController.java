package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Book;
import com.example.demo.entities.BookCategory;
import com.example.demo.entities.BookPublisher;
import com.example.demo.services.BookCategoryService;

@Controller
@RequestMapping("category/manage")
public class BookCategoryController {
	@Autowired private BookCategoryService bookCategoryService;
	@RequestMapping("list")
	public String bookList(Book book,Model model)
	{
		List<BookCategory> list=bookCategoryService.getCategoryList();
		model.addAttribute("clist",list);
		
		return "category/category-list";
	}
	
	@RequestMapping("add")
	public String addPublisher()
	{
		return "category/add-category";
	}
	@PostMapping("save")
	public String saveCategory(String category,String description)
    {
		BookCategory cat =new BookCategory();
		cat.setCategory(category);
		cat.setDescription(description);
		
		bookCategoryService.createPublisher(cat);
		
		return "redirect:list";
	}
	@RequestMapping("edit")
	public String EditCategory(@RequestParam int cid, Model model)
	{    BookCategory c=bookCategoryService.getBookCategory(cid);
	     model.addAttribute("cat",c);
		return "category/edit-category";
	}
	@RequestMapping("update")
	
	public String UpdateCategory(BookCategory bookCategory)
	{
	bookCategoryService.updateCategory(bookCategory);

	return "redirect:list";
    }
	@RequestMapping("remove")
	public String removeCategory(@RequestParam int cid)
	{ 
		bookCategoryService.removebyId(cid);
		return "redirect:list";
	}
}
