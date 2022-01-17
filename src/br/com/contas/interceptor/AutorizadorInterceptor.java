package br.com.contas.interceptor;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter{
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller)
			throws Exception {
		String uri = request.getRequestURI();
		if(uri.endsWith("loginForm") || uri.endsWith("efetuaLogin") || uri.contains("resources")) {
			return true;
		}
		
		if(Objects.nonNull(request.getSession().getAttribute("usuarioLogado"))) {
			return true;
		}else {
			response.sendRedirect("loginForm");
			return false;
		}
	}
}
