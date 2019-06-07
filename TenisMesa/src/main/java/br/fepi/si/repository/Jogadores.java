package br.fepi.si.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.fepi.si.model.Jogador;

public class Jogadores implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager em;
	
	public Jogadores(EntityManager em) {
		this.em = em;
	}
	
	public List<String> nacionalidade (String nacionalidade){
		String query = "select distinct nacionalidade from Jogador"
				+ " where upper(nacionalidade) like upper(:nacionalidade)";
		TypedQuery<String> buscaNacionalidades = em.createQuery(query, String.class);
		buscaNacionalidades.setParameter("nacionalidade", "%"+nacionalidade+"%");
		return buscaNacionalidades.getResultList();
	}
	
	public Jogador jogadorId(Long id) {
		return em.find(Jogador.class, id );
	}
	
	public List<Jogador> todos(){
		TypedQuery<Jogador> query = em.createQuery("from Jogador j order by j.id", Jogador.class);
		return query.getResultList();
	}
	
	public void adicionar (Jogador jogador) {
		this.em.persist(jogador);
	}
	
	public void guardar (Jogador jogador) {
		this.em.merge(jogador);
	}
	
	public void remover (Jogador jogador) {
		this.em.remove(jogador);
	}
}
