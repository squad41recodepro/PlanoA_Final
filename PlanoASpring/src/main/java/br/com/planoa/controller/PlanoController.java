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

import br.com.planoa.model.Plano;
import br.com.planoa.repository.DiciplinaRepository;
import br.com.planoa.repository.PlanoRepository;
import br.com.planoa.repository.ProfessorRepository;


@Controller
@RequestMapping("/plano")

public class PlanoController {

	@Autowired
	private PlanoRepository planoRepository;
	
    @Autowired
    private DiciplinaRepository diciplinaRepository;
    
    @Autowired
    private ProfessorRepository professorRepository;

	// LISTA ***********************************************************************
	@GetMapping
	public ModelAndView listar() {

		ModelAndView modelAndView = new ModelAndView("plano/lista.html");
		List<Plano> planos = planoRepository.findAll();
		modelAndView.addObject("planos", planos);

		return modelAndView;
	}

	// CADASTRA
	// ***********************************************************************
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("plano/cadastro.html");
		modelAndView.addObject("plano", new Plano());
        modelAndView.addObject("diciplina", diciplinaRepository.findAll());
        modelAndView.addObject("professor", professorRepository.findAll());

		return modelAndView;
	}
	
	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Plano plano, @RequestParam("filePlano") MultipartFile file)
			throws IOException {
		try

		{
			plano.setImagem(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}

		ModelAndView modelAndView = new ModelAndView("redirect:/plano");
		planoRepository.save(plano);
		return modelAndView;
	}

	//Mostra a imagem
	@GetMapping("/imagem/{id}")
	@ResponseBody
	public byte[] exibirImagen(@PathVariable("id") Long idPlano) {
		Plano plano = this.planoRepository.getReferenceById(idPlano);
		return plano.getImagem();
	}

	// DETALHAR
	// ***********************************************************************
	@GetMapping("/{id}")
	public ModelAndView detalhar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("plano/detalhar.html");

		Plano plano = planoRepository.getReferenceById(id);
		modelAndView.addObject("plano", plano);

		return modelAndView;
	}

	// EXCLUIR
	// ***********************************************************************
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/plano");
		planoRepository.deleteById(id);

		return modelAndView;
	}

	// EDITAR
	// ***********************************************************************
	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("plano/edicao");

		//Plano plano = planoRepository.getReferenceById(id);
		//modelAndView.addObject("plano", plano);
		modelAndView.addObject("plano", new Plano());
        modelAndView.addObject("diciplina", diciplinaRepository.findAll());
        modelAndView.addObject("professor", professorRepository.findAll());

		return modelAndView;
	}

	@PostMapping("/{id}/editar")
	public ModelAndView editar(Plano plano, @RequestParam("filePlano") MultipartFile file)
			throws IOException {
		try

		{
			plano.setImagem(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}

		ModelAndView modelAndView = new ModelAndView("redirect:/plano");

		planoRepository.save(plano);

		return modelAndView;
	}

}