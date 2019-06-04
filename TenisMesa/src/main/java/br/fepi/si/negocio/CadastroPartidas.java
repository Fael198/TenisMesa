package br.fepi.si.negocio;

import java.io.Serializable;

import br.fepi.si.repository.Partidas;

public class CadastroPartidas implements Serializable {

	private static final long serialVersionUID = 1L;

	private Partidas partidas;
	
	public CadastroPartidas(Partidas partidas) {
		this.partidas = partidas;
	}

	public Partidas getPartidas() {
		return partidas;
	}

	public void setPartidas(Partidas partidas) {
		this.partidas = partidas;
	}
}
