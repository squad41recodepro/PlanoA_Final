package br.com.planoa.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.planoa.model.Professor;
import br.com.planoa.repository.ProfessorRepository;

@Controller
@RequestMapping("/professor")

public class ProfessorController {

	@Autowired
	private ProfessorRepository professorRepository;

	// LISTA ***********************************************************************
	@GetMapping
	public ModelAndView listar() {

		ModelAndView modelAndView = new ModelAndView("professor/lista.html");
		List<Professor> professores = professorRepository.findAll();
		modelAndView.addObject("professors", professores);

		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("professor/cadastro.html");
		modelAndView.addObject("professor", new Professor());

		return modelAndView;
	}

	// CADASTRA
	// ***********************************************************************
	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Professor professor, @RequestParam("fileProfessor") MultipartFile file)
			throws IOException {
		try

		{
			professor.setImagem(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}

		ModelAndView modelAndView = new ModelAndView("redirect:/professor");
		professorRepository.save(professor);
		return modelAndView;
	}

	//Mosta a imagem
	@GetMapping("/imagem/{id}")
	@ResponseBody
	public byte[] exibirImagen(@PathVariable("id") Long idProfessor) {
		Professor professor = this.professorRepository.getReferenceById(idProfessor);
		return professor.getImagem();
	}

	// DETALHAR
	// ***********************************************************************
	@GetMapping("/{id}")
	public ModelAndView detalhar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("professor/detalhar.html");

		Professor professor = professorRepository.getReferenceById(id);
		modelAndView.addObject("professor", professor);

		return modelAndView;
	}

	// EXCLUIR
	// ***********************************************************************
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/professor");
		professorRepository.deleteById(id);

		return modelAndView;
	}

	// EDITAR
	// ***********************************************************************
	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("professor/edicao");

		Professor professor = professorRepository.getReferenceById(id);
		modelAndView.addObject("professor", professor);

		return modelAndView;
	}

	@PostMapping("/{id}/editar")
	public ModelAndView editar(Professor professor, @RequestParam("fileProfessor") MultipartFile file)
			throws IOException {
		try

		{
			professor.setImagem(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}

		ModelAndView modelAndView = new ModelAndView("redirect:/professor");

		professorRepository.save(professor);

		return modelAndView;
	}

}