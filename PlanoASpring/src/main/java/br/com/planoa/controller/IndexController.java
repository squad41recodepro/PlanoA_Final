package br.com.planoa.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
//@RequestMapping("/index")
public class IndexController {


	@GetMapping("/")
	public String Index() { 
		return "Index";
	}
	
	@GetMapping("/index")
	public ModelAndView index() { // É chamada quando se tem "/cliente/cadastrar"
		ModelAndView modelAndView = new ModelAndView("/index.html");
		return modelAndView;
	}

		
}

