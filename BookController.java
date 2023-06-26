package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Book;
import com.example.demo.entities.BookCategory;
import com.example.demo.services.BookCategoryService;
import com.example.demo.services.BookService;

@Controller
@RequestMapping("book/manage")
public class BookController {
@Autowired private BookService bookService;

@RequestMapping("list")
public String bookList(Book book,Model model)
{
	List<Book> list=bookService.getBookList();
	model.addAttribute("blist",list);
	
	return "book/book-list";
}
@RequestMapping("add")
public String addBook()
{
	return "book/add-book";
}
@RequestMapping("save")
public String saveBook(String title,String author,int catid,int pubid,int copies,int price)
{
	Book b =new Book();
	b.setAuthor(author);
	b.setCatid(catid);
	b.setPubid(pubid);
	b.setCopies(copies);
	b.setCopies(copies);
	b.setPrice(price);
	
	bookService.createbook(b);
	
	return "redirect:list";
}
}
