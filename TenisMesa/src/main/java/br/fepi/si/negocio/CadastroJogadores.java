package br.fepi.si.negocio;

import java.io.Serializable;

import br.fepi.si.model.Jogador;
import br.fepi.si.model.Partida;
import br.fepi.si.negocio.exception.NegocioException;
import br.fepi.si.repository.Jogadores;
import br.fepi.si.repository.Partidas;

public class CadastroJogadores implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Jogadores jogadores;
	private Partidas partidas;
	
	public CadastroJogadores(Jogadores jogadores) {
		this.jogadores = jogadores;
	}
	
	public void salvar(Jogador jogador) throws NegocioException {
		this.jogadores.guardar(jogador);
	}
	
	public void excluir (Jogador jogador, Partida partida) throws NegocioException {
		
		jogador = this.jogadores.jogadorId(jogador.getIdJogador());
		partida = this.partidas.porId(partida.getIdPartida());
		
		if(partida.getJogadorUm() != null && partida.getJogadorDois() != null) {
			throw new NegocioException("Jogador não pode ser excluido pois está em uma partida!");
		}
		this.jogadores.remover(jogador);
	}
}
