package br.fepi.si.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bola")
public class Bola {
	
	@Id
	@GeneratedValue
	private int idBola;

	public int getIdBola() {
		return idBola;
	}

	public void setIdBola(int idBola) {
		this.idBola = idBola;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idBola;
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
		Bola other = (Bola) obj;
		if (idBola != other.idBola)
			return false;
		return true;
	}
	
	
}
