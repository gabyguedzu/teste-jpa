package br.com.guedes.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.guedes.jpa.modelo.Conta;

public class CriaConta {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();	
		
		Conta conta = new Conta();
		
		conta.setAgencia(4545);
		conta.setTitular("Gabriela Guedes");
		conta.setNumero(45454);
		conta.setSaldo(500.0);
		
		//maneged
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		em.close();
		
		//detached
		EntityManager em2 = emf.createEntityManager();
		em2.getTransaction().begin();
		conta.setSaldo(600.0);
		em2.merge(conta);
		em2.getTransaction().commit();
		
	}
}
