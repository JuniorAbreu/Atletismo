package br.com.fatec.atletismo.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.fatec.atletismo.dao.PaisDAO;
import br.com.fatec.atletismo.dao.AtletaDAO;
import br.com.fatec.atletismo.domain.Pais;
import br.com.fatec.atletismo.domain.Atleta;

@ManagedBean
@ViewScoped
public class AtletaBean {
	
	private Atleta atleta;
	List <Atleta> atletas;
	List<Pais> cidades;
	
	public List<Pais> getCidades() {
		return cidades;
	}
	public void setCidades(List<Pais> cidades) {
		this.cidades = cidades;
	}
	public Atleta getCliente() {
		return atleta;
	}
	public void setCliente(Atleta atleta) {
		this.atleta = atleta;
	}
	public List<Atleta> getClientes() {
		return atletas;
	}
	public void setClientes(List<Atleta> atletas) {
		this.atletas = atletas;
	}
	public void novo(){
		atleta=new Atleta();
		PaisDAO cidadeDAO=new PaisDAO();
		cidades=cidadeDAO.listar("nome");
	}
	@PostConstruct
	public void listar(){
		
		try {
			AtletaDAO clienteDAO=new AtletaDAO();
			atletas=clienteDAO.listar();
			
		} catch (Exception e) {
			// TODO: handle exception
			Messages.addGlobalError("Erro ao listar");
		}
		
		
	}
	public void salvar(){
		try {
			AtletaDAO clienteDAO=new AtletaDAO();
			clienteDAO.merge(atleta);
			atletas=clienteDAO.listar();
			Messages.addGlobalInfo("Item salvo");
			PaisDAO cidadeDAO=new PaisDAO();
			cidades=cidadeDAO.listar("nome");
			
			novo();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			Messages.addGlobalError("Erro ao salvar");
			e.printStackTrace();
		}
		
	}
	public void editar(ActionEvent evento){
		atleta= (Atleta) evento.getComponent().getAttributes().get("clienteSelelcionado");
		PaisDAO cidadeDAO=new PaisDAO();
		cidades=cidadeDAO.listar("nome");
	
	}
	public void excluir(ActionEvent evento){
		try {
			atleta= (Atleta) evento.getComponent().getAttributes().get("clienteSelelcionado");
			AtletaDAO clienteDAO=new AtletaDAO();
			clienteDAO.excluir(atleta);
			atletas=clienteDAO.listar();
			Messages.addGlobalInfo("Item excluido");
			
		} catch (Exception e) {
			// TODO: handle exception
			Messages.addGlobalError("Erro ao excluir");
			e.printStackTrace();
		}
	}

}
