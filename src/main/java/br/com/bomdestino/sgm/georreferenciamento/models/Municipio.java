package br.com.bomdestino.sgm.georreferenciamento.models;

import java.io.Serializable;

public class Municipio implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String nome;
	
	public Municipio() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
