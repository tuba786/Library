package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.BookPublisher;
import com.example.demo.services.BookPublisherService;

@Controller
@RequestMapping("publisher/manage")
public class BookPublisherController {
	@Autowired private BookPublisherService bookPublisherService;

	@RequestMapping("list")
	public String bookList(BookPublisherController publisher,Model model)
	{
		List<BookPublisher> list=bookPublisherService.getPublisherList();
		model.addAttribute("plist",list);
		
		return "publisher/publisher-list";
	}	
	@RequestMapping("add")
	public String addPublisher()
	{
		return "publisher/add-publisher";
	}
	@PostMapping("save")
	public String savePublisher(String publisher,String phone,String email)
    {
		BookPublisher bookPub =new BookPublisher();
		bookPub.setPublisher(publisher);
		bookPub.setPhone(phone);
		bookPub.setEmail(email);
		bookPublisherService.createPublisher(bookPub);
		
		return "redirect:list";
	}	
	@RequestMapping("edit")
	public String EditPublisher(@RequestParam int pid, Model model)
	{    BookPublisher p=bookPublisherService.getBookPublisher(pid);
	     model.addAttribute("pub",p);
		return "publisher/edit-publisher";
	}
	
	@RequestMapping("update")
	
		public String UpdatePublisher(BookPublisher bookPublisher)
		{
		bookPublisherService.updatePublisher(bookPublisher);

		return "redirect:list";
	    }
	@RequestMapping("remove")
	public String removePublisher(@RequestParam int pid)
	{ 
		bookPublisherService.removebyId(pid);
		return "redirect:list";
	}
	
}
