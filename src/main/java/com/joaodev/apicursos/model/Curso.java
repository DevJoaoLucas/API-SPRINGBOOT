package com.joaodev.apicursos.model;

public class Curso {
	private int id;
	private String nome;
	private String categoria;
	
	public Curso() {}
	
	public Curso(int id, String nome, String categoria) {
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
