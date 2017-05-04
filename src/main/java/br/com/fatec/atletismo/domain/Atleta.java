package br.com.fatec.atletismo.domain;
import java.io.Serializable;

import javax.persistence.Entity;
@Entity
public class Atleta extends GenericDomain implements Serializable{
	
	private static final long serialVersionUID = -3745069472513230633L;
	private String nome;	
	private String sexo;
	private Pais pais;
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	
}
