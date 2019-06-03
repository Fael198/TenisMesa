package br.fepi.si.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import br.fepi.si.model.Jogador;
import br.fepi.si.repository.Jogadores;
import br.fepi.si.util.DataSource;

@FacesConverter(forClass = Jogador.class)
public class PessoaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		Jogador retorno = null;
		EntityManager em = DataSource.getEntityManager();
		try {
			if (arg2 != null && !"".equals(arg2)){
				retorno = new Jogadores(em).jogadorId(new Long(arg2));
			}
			return retorno;
		} finally {
			em.close();
		}
		
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 != null){
			Jogador jogador = ((Jogador) arg2);
			return jogador.getIdJogador() == null ? null : jogador.getIdJogador().toString();
		}
		return null;
	}

}
