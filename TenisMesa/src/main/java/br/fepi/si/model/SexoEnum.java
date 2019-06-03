package br.fepi.si.model;

public enum SexoEnum {

	MASCULINO("Masculino"),FEMININO("Feminino");
	
	private String descricao;
	
	SexoEnum(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
