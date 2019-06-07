package br.fepi.si.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.fepi.si.model.Partida;
import br.fepi.si.negocio.CadastroJogadores;
import br.fepi.si.negocio.CadastroPartidas;
import br.fepi.si.negocio.exception.NegocioException;
import br.fepi.si.repository.Jogadores;
import br.fepi.si.repository.Partidas;
import br.fepi.si.util.DataSource;

@ManagedBean
@ViewScoped
public class PartidasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Partida> partidas;
	
	private Partida partidaSelecionada;
	
	public void consultar() {
		EntityManager em = DataSource.getEntityManager();
		partidas = new Partidas(em).todos();
		em.clear();
	}

	public void excluir() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		EntityManager em = DataSource.getEntityManager();
		EntityTransaction et = em.getTransaction();
		
		CadastroPartidas cadastro = 
				new CadastroPartidas(new Partidas(em));
		
		try {
			et.begin();
			cadastro.excluir(this.partidaSelecionada);
			context.addMessage(null, 
					new FacesMessage("Partida excluído com sucesso."));
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
	
	public List<Partida> getPartidas() {
		return partidas;
	}

	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}

	public Partida getPartidaSelecionada() {
		return partidaSelecionada;
	}

	public void setPartidaSelecionada(Partida partidaSelecionada) {
		this.partidaSelecionada = partidaSelecionada;
	}
	
	
	
}
