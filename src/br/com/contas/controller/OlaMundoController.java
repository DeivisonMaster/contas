package br.com.contas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OlaMundoController {
	
	@RequestMapping("/olaMundoSpring")
	public String olaMundo() {
		System.out.println("Executando primeira l�gica Spring");
		return "ok";
	}
}
