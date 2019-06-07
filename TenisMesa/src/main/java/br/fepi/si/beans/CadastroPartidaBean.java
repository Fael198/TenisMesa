package br.fepi.si.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.fepi.si.model.Jogador;
import br.fepi.si.model.Partida;
import br.fepi.si.negocio.CadastroPartidas;
import br.fepi.si.negocio.exception.NegocioException;
import br.fepi.si.repository.Jogadores;
import br.fepi.si.repository.Partidas;
import br.fepi.si.util.DataSource;

@ManagedBean
@ViewScoped
public class CadastroPartidaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Partida partida;
	private List<Jogador> todosJogadores = new ArrayList<>();
	
	public void prepararCadastro() {
		EntityManager em = DataSource.getEntityManager();
		try {
			this.todosJogadores = new Jogadores(em).todos();
		} finally {
			em.close();
		} if(this.partida == null) {
			this.partida = new Partida();
		}
	}
	
	public void salvar() {
		
		EntityManager em = DataSource.getEntityManager();
		EntityTransaction et = em.getTransaction();
		FacesContext faces = FacesContext.getCurrentInstance();
		
		try {
			et.begin();
			CadastroPartidas cadastro = new CadastroPartidas(new Partidas(em));
			cadastro.salvar(partida);
			this.partida = new Partida();
			faces.addMessage(null, new FacesMessage("Salvo com sucesso!"));
			et.commit();
		} catch (NegocioException e) {
			et.rollback();
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			faces.addMessage(null, mensagem);
		} finally {
			em.close();
		}
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public List<Jogador> getTodosJogadores() {
		return todosJogadores;
	}

	public void setTodosJogadores(List<Jogador> todosJogadores) {
		this.todosJogadores = todosJogadores;
	}
	
	
}
	
