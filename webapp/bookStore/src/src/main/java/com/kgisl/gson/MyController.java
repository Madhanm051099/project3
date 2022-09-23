package com.kgisl.gson;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class MyController {
    @RequestMapping(method = RequestMethod.GET)

	public String home(Model model) {
		System.out.println("MyController Requested, locale = ");
		model.addAttribute("serverTime", "formattedDate");
		return "home";
	}  
}
