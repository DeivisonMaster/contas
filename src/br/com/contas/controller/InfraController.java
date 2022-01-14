package br.com.contas.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.contas.dao.ConnectionFactory;


@Controller
public class InfraController {

	@RequestMapping("/tabelas")
	public String criaBanco() throws SQLException {
		Connection conexao = new ConnectionFactory().getConnection();

		PreparedStatement st11 = conexao.prepareStatement("create table contas "
				+ "(id INT PRIMARY KEY auto_increment, "
				+ "descricao VARCHAR(255), "
				+ "valor DECIMAL, "
				+ "paga VARCHAR(20), "
				+ "data_pagamento DATETIME, "
				+ "tipo VARCHAR(20))");
		st11.execute();
		
		PreparedStatement st22 = conexao.prepareStatement("create table usuarios (login VARCHAR(255),senha VARCHAR(255));");
		st22.execute();

		PreparedStatement st3 = conexao.prepareStatement("insert into usuarios (login, senha) values ('admin', '123');");
		st3.execute();
		
		conexao.close();
		
		return "infra-ok";

	}
}
