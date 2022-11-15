package br.com.bibliotecamagica.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.bibliotecamagica.model.Genero;
import br.com.bibliotecamagica.repository.GeneroRepository;

@Controller
@RequestMapping("/genero")
public class GeneroController {
	
	@Autowired
	private GeneroRepository generoRepository;
	
	@GetMapping
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("genero/home");
		
		List<Genero> genero = generoRepository.findAll();
		modelAndView.addObject("genero", genero);
		
		return modelAndView;
	}
	
	@GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("genero/formulario");

        modelAndView.addObject("genero", new Genero());
       
        return modelAndView;
    }
    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("genero/formulario");

        modelAndView.addObject("genero", generoRepository.getOne(id));
        
        return modelAndView;
    }
    
	@PostMapping({"/cadastrar", "/{id}/editar"})
	public String Salvar(Genero genero){

		generoRepository.save(genero);

		return "redirect:/genero";
	}

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id) {
       generoRepository.deleteById(id);

        return "redirect:/genero";
    }
}

