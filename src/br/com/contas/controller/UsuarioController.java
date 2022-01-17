package br.com.contas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.contas.dao.UsuarioDAO;
import br.com.contas.model.Usuario;

@Controller
public class UsuarioController {


	@RequestMapping("/loginForm")
	public String login() {
		return "usuario/login";
	}
	
	@RequestMapping("/efetuaLogin")
	public String login(Usuario usuario, HttpSession sessao) {
		UsuarioDAO dao  = new UsuarioDAO();
		boolean isUsuario = dao.existeUsuario(usuario);
		if(isUsuario) {
			sessao.setAttribute("usuarioLogado", usuario);
			return "menu";
		}else {
			return "redirect:loginForm";
		}
	}
	
}
