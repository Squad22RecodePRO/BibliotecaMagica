package com.squad22.bibliotecamagica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagsController {

	
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/contato")
	public String contato() {
		return "contato";
	}
	@GetMapping("/quemsomos")
	public String quemsomos() {
		return "quemsomos";
	}
	
}
