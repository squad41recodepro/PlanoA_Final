package br.com.planoa.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class IndexController {


	@GetMapping("/index")
	public ModelAndView index() { 
		ModelAndView modelAndView = new ModelAndView("/index.html");

		return modelAndView;
	}
	
	@GetMapping("/planosdeaula")
	public ModelAndView planosdeaula() { 
		ModelAndView modelAndView = new ModelAndView("/planosDeAula.html");
		return modelAndView;
	}
	
	@GetMapping("/perguntasfrequentes")
	public ModelAndView perguntasfrequentes() { 
		ModelAndView modelAndView = new ModelAndView("/perguntasFrequentes.html");
		return modelAndView;
	}

	@GetMapping("/sobrenos")
	public ModelAndView sobrenos() { 
		ModelAndView modelAndView = new ModelAndView("/sobreNos.html");
		return modelAndView;
	}

	@GetMapping("/contato")
	public ModelAndView contato() { 
		ModelAndView modelAndView = new ModelAndView("/contato.html");
		return modelAndView;
	}


}

