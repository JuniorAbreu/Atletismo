package br.com.fatec.atletismo.domain;

import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Prova extends GenericDomain{
	
	private String nome;
	private String tipo;
	private String sexoAtleta;


	private Atleta atleta;
	
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getSexoAtleta() {
		return sexoAtleta;
	}

	public void setSexoAtleta(String sexoAtleta) {
		this.sexoAtleta = sexoAtleta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Atleta getAtleta() {
		return atleta;
	}

	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}

	public String getSexo() {
		return sexoAtleta;
	}

	public void setSexo(String sexo) {
		this.sexoAtleta = sexo;
	}
	
	
	

}
