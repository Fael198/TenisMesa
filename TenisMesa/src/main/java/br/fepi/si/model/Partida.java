package br.fepi.si.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "partida")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Partida implements Premiacao{

	private Long idPartida;
	private Date data;
	private double duracao;
	private int pontJogadorUm;
	private int pontJogadorDois;
	private String local;
	private Jogador jogadorUm;
	private Jogador jogadorDois;
	
	@Id
	@GeneratedValue
	public Long getIdPartida() {
		return idPartida;
	}
	public void setIdPartida(Long idPartida) {
		this.idPartida = idPartida;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data", nullable = false)
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	@Column(name = "duracao", length = 60, nullable = false)
	public double getDuracao() {
		return duracao;
	}
	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}
	
	@Column(name = "ponJogadorUm", length = 60, nullable = false)
	public int getPontJogadorUm() {
		return pontJogadorUm;
	}
	public void setPontJogadorUm(int pontJogadorUm) {
		this.pontJogadorUm = pontJogadorUm;
	}
	
	@Column(name = "ponJogadorDois", length = 60, nullable = false)
	public int getPontJogadorDois() {
		return pontJogadorDois;
	}
	public void setPontJogadorDois(int pontJogadorDois) {
		this.pontJogadorDois = pontJogadorDois;
	}
	
	@Column(name = "local", length = 60, nullable = false)
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "idJogadorUm")
	public Jogador getJogadorUm() {
		return jogadorUm;
	}
	public void setJogadorUm(Jogador jogadorUm) {
		this.jogadorUm = jogadorUm;
	}
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "idJogadorDois")
	public Jogador getJogadorDois() {
		return jogadorDois;
	}
	public void setJogadorDois(Jogador jogadorDois) {
		this.jogadorDois = jogadorDois;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPartida == null) ? 0 : idPartida.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partida other = (Partida) obj;
		if (idPartida == null) {
			if (other.idPartida != null)
				return false;
		} else if (!idPartida.equals(other.idPartida))
			return false;
		return true;
	}
		
}
