package br.com.contas.model;

public enum TipoDaConta {
	ENTRADA(0, "Entrada"),
	SAIDA(1, "Saida");
	
	private int id;
	private String descricao;
	
	TipoDaConta(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	public int getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
