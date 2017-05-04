package br.com.fatec.atletismo.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.fatec.atletismo.dao.PaisDAO;
import br.com.fatec.atletismo.domain.Pais;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PaisBean implements Serializable{
	private List<Pais> cidades;
	private Pais cidade;




	public Pais getCidade() {
		return cidade;
	}

	public void setCidade(Pais cidade) {
		this.cidade = cidade;
	}

	public List<Pais> getCidades() {
		return cidades;
	}
	
	public void setCidades(List<Pais> cidades) {
		this.cidades = cidades;
	}
	
	@PostConstruct
	public void listar(){
		try{
			PaisDAO cidadeDAO = new PaisDAO();
			cidades = cidadeDAO.listar();
		}catch(RuntimeException erro){
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar as cidades");
			erro.printStackTrace();
		}
	}
	public void novo(){
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Messages.addFlashGlobalError("Erro ao gerar cidade");
		}
		
		cidade=new Pais();

	}
	
	public void salvar(){
		
		try {
			PaisDAO cidadeDAO=new PaisDAO();
			cidadeDAO.merge(cidade);
			cidade=new Pais();
			cidades=cidadeDAO.listar();
			
		
			Messages.addGlobalInfo("Item salvo");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			Messages.addGlobalInfo("Erro");
			e.printStackTrace();
		}
	}
	public void excluir(ActionEvent evento){
		try {
			cidade= (Pais) evento.getComponent().getAttributes().get("cidadeSelecionada");
			PaisDAO cidadeDAO=new PaisDAO();
			cidadeDAO.excluir(cidade);
			cidades=cidadeDAO.listar();
			Messages.addGlobalInfo("Item editado");
		} catch (Exception e) {
			// TODO: handle exception
			Messages.addGlobalError("Erro");
			e.printStackTrace();
		}
		
	}
	public void editar(ActionEvent evento){
		try {
			cidade= (Pais) evento.getComponent().getAttributes().get("cidadeSelecionada");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			Messages.addGlobalError("Erro");
			e.printStackTrace();
		}
	}
		
	
	
	}
