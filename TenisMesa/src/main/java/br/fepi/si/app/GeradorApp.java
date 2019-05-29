package br.fepi.si.app;

import javax.persistence.Persistence;

public class GeradorApp {

	public static void main(String[] args) {
		
		Persistence.createEntityManagerFactory("TenisMesaPU");

	}

}
