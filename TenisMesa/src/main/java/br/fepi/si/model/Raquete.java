package br.fepi.si.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "raquete")
public class Raquete implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int idRaquete;
	
	@Column(name = "modelo", length = 60, nullable = false)
	private String modelo;

	public int getIdRaquete() {
		return idRaquete;
	}

	public void setIdRaquete(int idRaquete) {
		this.idRaquete = idRaquete;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idRaquete;
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
		Raquete other = (Raquete) obj;
		if (idRaquete != other.idRaquete)
			return false;
		return true;
	}
		
	
}
