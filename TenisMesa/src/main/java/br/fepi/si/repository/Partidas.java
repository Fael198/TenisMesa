package br.fepi.si.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.fepi.si.model.Partida;

public class Partidas implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager em;
	
	public Partidas(EntityManager em) {
		this.em = em;
	}
	
	public List<String> descricoes (String descricao){
		String query = "select distinct descricao from Partida"
				+ " where upper(descricao) like upper(:descricao)";
		TypedQuery<String> buscaDescricoes = em.createQuery(query, String.class);
		buscaDescricoes.setParameter("descricao", "%"+descricao+"%");
		return buscaDescricoes.getResultList();
	}
	
	public List<Partida> todos() {
		TypedQuery<Partida> query = em.createQuery("from Partida", Partida.class);
		return query.getResultList();
	}
	
	public Partida porId (Long id) {
		return em.find(Partida.class, id);
	}
	
	public void adicionar (Partida partida) {
		em.persist(partida);
	}
	
	public void guardar (Partida partida) {
		em.merge(partida);
	}
	
	public void remover (Partida partida) {
		this.em.remove(partida);
	}
}
