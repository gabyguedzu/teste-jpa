package br.com.guedes.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.guedes.jpa.modelo.Conta;

public class CriaContaComSaldo {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();	
		
		Conta conta = new Conta();
		
		conta.setAgencia(124545);
		conta.setTitular("Gabriela Guedes");
		conta.setNumero(4435454);
		conta.setSaldo(20.000);
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
	}
}
