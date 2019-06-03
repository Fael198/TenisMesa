package br.fepi.si.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.fepi.si.model.Jogador;
import br.fepi.si.model.SexoEnum;
import br.fepi.si.negocio.CadastroJogadores;
import br.fepi.si.negocio.exception.NegocioException;
import br.fepi.si.repository.Jogadores;
import br.fepi.si.util.DataSource;

@ManagedBean
@ViewScoped
public class CadastroJogadorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Jogador jogador;
	
	public void prepararCadastro() {
		if(this.jogador == null) {
			this.jogador = new Jogador();
		}
	}

	public void salvar(){
		
		EntityManager em = DataSource.getEntityManager();
		EntityTransaction et = em.getTransaction();
		FacesContext faces = FacesContext.getCurrentInstance();
		
		try {
			et.begin();
			CadastroJogadores cadastro = new CadastroJogadores(new Jogadores(em));
			cadastro.salvar(jogador);
			this.jogador = new Jogador();
			faces.addMessage(null, new FacesMessage("Salvo com sucesso."));
			et.commit();
		} catch (NegocioException e) {
			et.rollback();
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			faces.addMessage(null, mensagem);
		}finally{
			em.close();
		}
	}
	
	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
	
	public SexoEnum[] getSexoEnum() {
		return SexoEnum.values();
	}
	
	
}
