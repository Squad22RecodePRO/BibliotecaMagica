package br.com.bibliotecamagica.controller;

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

import br.com.bibliotecamagica.model.Livro;
import br.com.bibliotecamagica.repository.GeneroRepository;
import br.com.bibliotecamagica.repository.LivroRepository;

@Controller
@RequestMapping("/catalogo")
public class BibliotecaController {
	
	@Autowired
	private LivroRepository livroRepository;
	
	
	@GetMapping
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("catalogo.html");
		
		List<Livro> livro = livroRepository.findAll();
		modelAndView.addObject("livro", livro);
		
		return modelAndView;
	}
	

	@GetMapping("/{id}")
	public ModelAndView resumo(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("catalogo.html");

		Livro livro = livroRepository.getOne(id);
		modelAndView.addObject("livro", livro);

		return modelAndView;
	}
	
	
	
	
  
    
	

}
