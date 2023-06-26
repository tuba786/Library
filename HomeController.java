package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.services.BookService;

@Controller
@RequestMapping("/bookstore/inventory")
public class HomeController {
	@Autowired private BookService bookService;
	@RequestMapping("/")
	public String getLoginView() {

		return "home/login";
	}

	@RequestMapping("login/validate")
	public String getHomeView(String username, String password) {
         if(username.equals("tuba")&&password.equals("Tub@")) {
		return "home/home-page";
	}
         return "home/login";  
}
	
}