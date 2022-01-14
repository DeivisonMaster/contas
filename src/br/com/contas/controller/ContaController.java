package br.com.contas.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping("/listaConta")
	public ModelAndView listaConta() {
		ContaDAO dao = new ContaDAO();
		ModelAndView mv = new ModelAndView("conta/lista");
		
		List<Conta> contas = dao.lista();
		mv.addObject("listaContas", contas);
		return mv;
	}
	
}
