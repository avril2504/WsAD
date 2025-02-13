package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

import modelo.entidad.Coche;

public class Borrar {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
		EntityManager em  =  emf.createEntityManager();
		
		System.out.println("EntityManager creado");
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		Coche coche = em.find(Coche.class, 1);
		System.out.println(coche);
		
		em.remove(coche);
		coche = em.find(Coche.class, 1);
		System.out.println(coche);
		et.commit();
		
		em.close();
	}

}
