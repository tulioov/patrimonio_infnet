package edu.infnet.patrimonio.negocio;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaConnection {
	
	private static EntityManagerFactory emf;
	
	private JpaConnection() {}
	
	public static EntityManagerFactory getEmf() {
		if(emf == null) {
			emf  = Persistence.createEntityManagerFactory("patrimonio");
		}
		return emf;
	}

}
