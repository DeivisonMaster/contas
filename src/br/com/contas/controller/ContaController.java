package br.com.contas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.contas.dao.ContaDAO;
import br.com.contas.model.Conta;

@Controller
public class ContaController {
	
	private ContaDAO dao;
	
	@Autowired
	public ContaController(ContaDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/cadastrar")
	public String cadastra(Conta conta) {
		return "conta/cadastroConta";
	}
	
	@RequestMapping("/adicionaConta")
	public String cadastraConta(@Valid Conta conta, BindingResult validacao) {
		if(validacao.hasErrors()) {
			return "conta/cadastroConta";
		}
		
		dao.adiciona(conta);
		return "conta/cadastroConta";
	}
	
	@RequestMapping("/exclui")
	public String remove(Conta conta) {
		dao.remove(conta);
		
		return "redirect:listaConta";
	}
	
	@RequestMapping("/pagarConta")
	public @ResponseBody String pagar(Conta conta) {
		dao.paga(conta.getId());
		conta = dao.buscaPorId(conta.getId());
		return conta.isPaga() == true ? "Pago" : "Não pago";
	}
	
	@RequestMapping("/listaConta")
	public ModelAndView listaConta() {
		ModelAndView mv = new ModelAndView("conta/lista");
		
		List<Conta> contas = dao.lista();
		mv.addObject("listaContas", contas);
		return mv;
	}
	
}
