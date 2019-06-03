package br.fepi.si.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.fepi.si.model.Partida;
import br.fepi.si.repository.Partidas;
import br.fepi.si.util.DataSource;

@ManagedBean
@ViewScoped
public class PartidasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Partida> partidas;
	
	public void consultar() {
		EntityManager em = DataSource.getEntityManager();
		partidas = new Partidas(em).todos();
		em.clear();
	}

	public void excluir() {
		
	}
	
	public List<Partida> getPartidas() {
		return partidas;
	}

	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}
	
}
