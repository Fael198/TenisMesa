package br.fepi.si.negocio;

import java.io.Serializable;

import br.fepi.si.model.Partida;
import br.fepi.si.negocio.exception.NegocioException;
import br.fepi.si.repository.Partidas;

public class CadastroPartidas implements Serializable {

	private static final long serialVersionUID = 1L;

	private Partidas partidas;
	
	public CadastroPartidas(Partidas partidas) {
		this.partidas = partidas;
	}

	public void salvar(Partida partida) throws NegocioException {
		this.partidas.guardar(partida);
	}
	
	public void excluir (Partida partida) throws NegocioException {
		partida = this.partidas.porId(partida.getIdPartida());
		this.partidas.remover(partida);
	}
}
