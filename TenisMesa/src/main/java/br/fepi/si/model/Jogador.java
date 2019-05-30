package br.fepi.si.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="jogador")
public class Jogador implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long idJogador;
	
	@Column(name = "nome", length = 60, nullable = false)
	private String nome;
	
	@Column(name = "quantidade", length = 60, nullable = false)
	private int quantidade;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dataNascimento", length = 60, nullable = false)
	private Date dataNascimento;
	
	@Column(name = "nacionalidade")
	private String nacionalidade;
	
	@Enumerated(EnumType.STRING)
	private SexoEnum sexoenum;
	
	public Long getIdJogador() {
		return idJogador;
	}
	public void setIdJogador(Long idJogador) {
		this.idJogador = idJogador;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public SexoEnum getSexoenum() {
		return sexoenum;
	}
	public void setSexoenum(SexoEnum sexoenum) {
		this.sexoenum = sexoenum;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idJogador == null) ? 0 : idJogador.hashCode());
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
		Jogador other = (Jogador) obj;
		if (idJogador == null) {
			if (other.idJogador != null)
				return false;
		} else if (!idJogador.equals(other.idJogador))
			return false;
		return true;
	}	
	
}
