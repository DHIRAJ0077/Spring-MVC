package springMVC3.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class Controller3 {
	@RequestMapping("/")
	public String get() {
		System.out.println("Controller- fetchMapping");
		return "index";
	}

	
}