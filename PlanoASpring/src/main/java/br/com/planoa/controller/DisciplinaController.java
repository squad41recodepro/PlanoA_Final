package br.com.planoa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.planoa.repository.DisciplinaRepository;
import br.com.planoa.model.Disciplina;

@Controller
@RequestMapping("/disciplina")
public class DisciplinaController {

	@Autowired
	private DisciplinaRepository disciplinaRepository; // Insere comandos de gerenciamento do banco

	// LISTAR
	@GetMapping
	public ModelAndView listar() {

		ModelAndView modelAndView = new ModelAndView("disciplina/lista.html");

		List<Disciplina> disciplina = disciplinaRepository.findAll();

		modelAndView.addObject("disciplinas", disciplina);

		return modelAndView;
	}

	// CADASTRAR
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("disciplina/cadastro.html");
		modelAndView.addObject("disciplina", new Disciplina());

		return modelAndView;
	}

	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Disciplina disciplina) {

		ModelAndView modelAndView = new ModelAndView("redirect:/disciplina");
		disciplinaRepository.save(disciplina);

		return modelAndView;
	}

	// DETALHAR INDIVICULAMENTE INFORMAÇÕES DO CADASTRO
	@GetMapping("/{id}")
	public ModelAndView detalhar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("disciplina/detalhar.html");

		Disciplina disciplina = disciplinaRepository.getReferenceById(id);
		modelAndView.addObject("disciplina", disciplina);

		return modelAndView;
	}

	// EXCLUIR
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/disciplina");

		disciplinaRepository.deleteById(id);

		return modelAndView;
	}

	// EDITAR
	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("disciplina/edicao");

		Disciplina disciplina = disciplinaRepository.getReferenceById(id);
		modelAndView.addObject("disciplina", disciplina);

		return modelAndView;
	}

	@PostMapping("/{id}/editar")
	public ModelAndView editar(Disciplina disciplina) {

		ModelAndView modelAndView = new ModelAndView("redirect:/disciplina");

		disciplinaRepository.save(disciplina);

		return modelAndView;
	}

}
