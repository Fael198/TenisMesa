package br.fepi.si.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.fepi.si.model.Jogador;
import br.fepi.si.model.Partida;
import br.fepi.si.negocio.CadastroJogadores;
import br.fepi.si.negocio.exception.NegocioException;
import br.fepi.si.repository.Jogadores;
import br.fepi.si.util.DataSource;

@ManagedBean
@ViewScoped
public class JogadoresBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Jogador> jogadores;
	
	private Jogador jogadorSelecionado;
	private Partida partidaSelecionada;
	
	public void consultar() {
		EntityManager em = DataSource.getEntityManager();
		Jogadores jogadores = new Jogadores(em);
		this.jogadores = jogadores.todos();
	}

	public void excluir() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		EntityManager em = DataSource.getEntityManager();
		EntityTransaction et = em.getTransaction();
		
		CadastroJogadores cadastro = 
				new CadastroJogadores(new Jogadores(em));
		
		try {
			et.begin();
			cadastro.excluir(this.jogadorSelecionado, this.partidaSelecionada);
			context.addMessage(null, 
					new FacesMessage("Jogador excluído com sucesso."));
			et.commit();
			this.consultar();
		} catch (NegocioException e) {
			et.rollback();
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem); 
		}finally {
			em.close();
		}
	}
	
	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public Jogador getJogadorSelecionado() {
		return jogadorSelecionado;
	}

	public void setJogadorSelecionado(Jogador jogadorSelecionado) {
		this.jogadorSelecionado = jogadorSelecionado;
	}

	public Partida getPartidaSelecionada() {
		return partidaSelecionada;
	}

	public void setPartidaSelecionada(Partida partidaSelecionada) {
		this.partidaSelecionada = partidaSelecionada;
	}
	
	
	
	
}
