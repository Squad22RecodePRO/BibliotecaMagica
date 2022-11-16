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

import br.com.bibliotecamagica.model.Usuario;
import br.com.bibliotecamagica.repository.UsuarioRepository;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("usuario/home.html");
		
		List<Usuario> usuario = usuarioRepository.findAll();
		modelAndView.addObject("usuario", usuario);
		
		return modelAndView;
	}
	
	@GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("usuario/cadastro");

        modelAndView.addObject("usuario", new Usuario());
       
        return modelAndView;
    }
    
	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Usuario usuario) throws IOException {

		ModelAndView modelAndView = new ModelAndView("redirect:/usuario");

		usuarioRepository.save(usuario);

		return modelAndView;
	}

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("usuario/editar.html");

        modelAndView.addObject("usuario", usuarioRepository.getOne(id));
        
        return modelAndView;
    }

    @PostMapping("/{id}/editar")
    public String salvar(Usuario usuario) {
    
        usuarioRepository.save(usuario);

        return "redirect:/usuario";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id) {
       usuarioRepository.deleteById(id);

        return "redirect:/usuario";
    }

}
