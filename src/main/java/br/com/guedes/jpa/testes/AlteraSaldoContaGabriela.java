package br.com.guedes.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.guedes.jpa.modelo.Conta;

public class AlteraSaldoContaGabriela {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Conta contaGabriela = em.find(Conta.class, 2L);
		
		em.getTransaction().begin();
		contaGabriela.setSaldo(60.000);
		em.getTransaction().commit();
	}
}
