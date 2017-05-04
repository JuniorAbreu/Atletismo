package br.com.fatec.atletismo.domain;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Pais extends GenericDomain implements Serializable{
	
	
	private String nome;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
