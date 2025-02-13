package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

import modelo.entidad.Coche;

public class Insertar {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
		EntityManager em  =  emf.createEntityManager();
		
		System.out.println("EntityManager creado");
		
		Coche coche =  new Coche();
		coche.setId(1);
		coche.setMarca("Toyota");
		coche.setModelo("Celica");
		coche.setKm(95000);
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(coche);
		tx.commit();
		
		em.close();
	}

}
