package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainJPA {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
		EntityManager em  =  emf.createEntityManager();
		
		System.out.println("EntityManager creado");
		em.close();
	}

}
