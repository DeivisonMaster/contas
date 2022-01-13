package br.com.contas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.contas.dao.ContaDAO;
import br.com.contas.model.Conta;

@Controller
public class ContaController {
	
	@RequestMapping("/cadastrar")
	public String cadastra(Conta conta) {
		return "cadastroConta";
	}
	
	@RequestMapping("/adicionaConta")
	public String cadastraConta(Conta conta) {
		ContaDAO dao = new ContaDAO();
		
		dao.adiciona(conta);
		return "cadastroConta";
	}
	
}
