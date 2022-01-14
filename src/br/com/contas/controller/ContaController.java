package br.com.contas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.contas.dao.ContaDAO;
import br.com.contas.model.Conta;

@Controller
public class ContaController {
	
	@RequestMapping("/cadastrar")
	public String cadastra(Conta conta) {
		return "conta/cadastroConta";
	}
	
	@RequestMapping("/adicionaConta")
	public String cadastraConta(@Valid Conta conta, BindingResult validacao) {
		if(validacao.hasErrors()) {
			return "conta/cadastroConta";
		}
		
		ContaDAO dao = new ContaDAO();
		dao.adiciona(conta);
		return "conta/cadastroConta";
	}
	
	@RequestMapping("/exclui")
	public String remove(Conta conta) {
		ContaDAO dao = new ContaDAO();
		dao.remove(conta);
		
		return "redirect:listaConta";
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
