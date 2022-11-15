package br.com.bibliotecamagica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import br.com.bibliotecamagica.model.Livro;
import br.com.bibliotecamagica.repository.LivroRepository;

@Controller
public class BibliotecaController {

	@Autowired
	private LivroRepository livroRepository;
	
	@GetMapping("/catalogo")
	public ModelAndView catalogo() {
		ModelAndView modelAndView = new ModelAndView("catalogo");

		List<Livro> livro = livroRepository.findAll();
		modelAndView.addObject("livro", livro);
		return modelAndView;

	}
	
	@GetMapping("/{id}")
	public ModelAndView ler(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("catalogo.html");

		Livro livro = livroRepository.getOne(id);
		modelAndView.addObject("livro", livro);

		return modelAndView;
	}
}
