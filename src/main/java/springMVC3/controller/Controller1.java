package springMVC3.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/electronics")
public class Controller1 {

//	 @RequestMapping(method = RequestMethod.GET)
	@GetMapping(path = { "/getmapping", "/fetchMapping" })
	public String get(HttpServletRequest req, HttpServletResponse res) {
		
		System.out.println("Controller- fetchMapping");
		return "admin";
	}

	// @GetMapping(path= {"/getmapping"}, params="name")
	// public String getParam(HttpServletRequest req, HttpServletResponse res) {
	@GetMapping(path = { "/getParam" })
	public String getParam(@RequestParam(name = "name", defaultValue = "Guest") String name) {
		System.out.println("Controller-  params=name: " + name);
		return "index";
	}

	// hello/getCustomer/1234/details
	@ResponseBody
	@GetMapping(path = { "/getCustomer/{customerId}/details" })
	public String getPathVariable(@PathVariable String customerId) {

		System.out.println("Controller-  params=customerId : " + customerId);
		return "Controller-  params=customerId : " + customerId;
	}

	
	
	
	@RequestMapping("/setCookie")
	public String setCookie(HttpServletResponse response) {
	    Cookie cookie = new Cookie("myCookie", "DangerValue");
	    cookie.setMaxAge(3600); // Cookie will expire in 1 hour
	    response.addCookie(cookie);
	    return "redirect:/electronics/second";
	}
	
	
	
	
	
	@RequestMapping("/second")
    public String secondPage(@CookieValue(value = "myCookie", defaultValue = "defaultCookieValue1") String myCookieValue, Model model) {
        // Use myCookieValue in your controller logic
        model.addAttribute("cookiesValue", myCookieValue);
        return "second";
    }
	
	
	@GetMapping(path = { "/getCookie" })
	public String getCookiesValue(HttpServletRequest req, @CookieValue("JSESSIONID") String jsessionCookie) {
		String value= "";
		Cookie[] cookies = req.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("JSESSIONID")) {
				value = cookie.getValue();
			}
		}
		System.out.println("Controller-  cookie=" + value);
		System.out.println("Controller-  jsessionCookie=" + jsessionCookie);
		return "index";
	}

	// @RequestMapping(method = RequestMethod.POST)
	@PostMapping
	public String post(HttpServletRequest req, HttpServletResponse res) {

		System.out.println("Controller- POST");
		return "index";
	}

	// @RequestMapping(method = RequestMethod.DELETE)
	@DeleteMapping
	public String delete(HttpServletRequest req, HttpServletResponse res) {

		System.out.println("Controller- DELETE");
		return "index";
	}
}
