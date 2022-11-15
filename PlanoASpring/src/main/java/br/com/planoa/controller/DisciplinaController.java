package br.com.planoa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.planoa.repository.DiciplinaRepository;
import br.com.planoa.model.Diciplina;

@Controller
@RequestMapping("/diciplina")
public class DisciplinaController {

	@Autowired
	private DiciplinaRepository diciplinaRepository; // Insere comandos de gerenciamento do banco

	// LISTAR
	@GetMapping
	public ModelAndView listar() {

		ModelAndView modelAndView = new ModelAndView("diciplina/lista.html");

		List<Diciplina> diciplina = diciplinaRepository.findAll();

		modelAndView.addObject("diciplinas", diciplina);

		return modelAndView;
	}

	// CADASTRAR
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("diciplina/cadastro.html");
		modelAndView.addObject("diciplina", new Diciplina());

		return modelAndView;
	}

	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Diciplina diciplina) {

		ModelAndView modelAndView = new ModelAndView("redirect:/diciplina");
		diciplinaRepository.save(diciplina);

		return modelAndView;
	}

	// DETALHAR INDIVICULAMENTE INFORMAÇÕES DO CADASTRO
	@GetMapping("/{id}")
	public ModelAndView detalhar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("diciplina/detalhar.html");

		Diciplina diciplina = diciplinaRepository.getReferenceById(id);
		modelAndView.addObject("diciplina", diciplina);

		return modelAndView;
	}

	// EXCLUIR
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/diciplina");

		diciplinaRepository.deleteById(id);

		return modelAndView;
	}

	// EDITAR
	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("diciplina/edicao");

		Diciplina diciplina = diciplinaRepository.getReferenceById(id);
		modelAndView.addObject("diciplina", diciplina);

		return modelAndView;
	}

	@PostMapping("/{id}/editar")
	public ModelAndView editar(Diciplina diciplina) {

		ModelAndView modelAndView = new ModelAndView("redirect:/diciplina");

		diciplinaRepository.save(diciplina);

		return modelAndView;
	}

}
