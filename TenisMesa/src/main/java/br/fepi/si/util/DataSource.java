package br.fepi.si.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataSource {

private static EntityManagerFactory factory ;
	
	static { factory = Persistence.createEntityManagerFactory("TenisMesaPU"); }
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
		
	}
	
}
