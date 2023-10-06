package com.ssafy.mvc;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.service.crawling;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@GetMapping({"/", "/home"})
	public String home(Locale locale, Model model) {		
		return "home";
	}
	
	@PostMapping("/recommend")
	public String doRecommend(String level, Model model) {
		model.addAttribute("list", crawling.search(level));
		model.addAttribute("level", level);
		return "result";
	}
	
}
