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
@RequestMapping("/livro")
public class LivroController {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private GeneroRepository generoRepository;
	
	@GetMapping
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("livro/home.html");
		
		List<Livro> livro = livroRepository.findAll();
		modelAndView.addObject("livro", livro);
		
		return modelAndView;
	}
	
	
	@GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("livro/cadastro");

        modelAndView.addObject("livro", new Livro());
        modelAndView.addObject("genero", generoRepository.findAll());
       
        return modelAndView;
    }
    
	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Livro livro, @RequestParam("fileCapa") MultipartFile fileCapa) throws IOException {
		
		try {
			livro.setCapa(fileCapa.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		ModelAndView modelAndView = new ModelAndView("redirect:/livro");

		livroRepository.save(livro);

		return modelAndView;
	}
	
	@GetMapping("/fileCapa/{id}")
	@ResponseBody
	public byte[] exibirImagem(@PathVariable("id") Long id) {
		Livro livro = this.livroRepository.getOne(id);
		return livro.getCapa();
	}	

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("livro/editar.html");

        modelAndView.addObject("livro", livroRepository.getOne(id));
        modelAndView.addObject("genero", generoRepository.findAll());
        
        return modelAndView;
    }

    @PostMapping("/{id}/editar")
    public String salvar(Livro livro) {
    	
        
    	livroRepository.save(livro);

        return "redirect:/livro";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id) {
       livroRepository.deleteById(id);

        return "redirect:/livro";
    }

}
