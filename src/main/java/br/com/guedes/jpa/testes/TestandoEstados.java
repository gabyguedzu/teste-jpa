package br.com.guedes.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.guedes.jpa.modelo.Conta;

public class TestandoEstados {
	
	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setAgencia(444);
		conta.setNumero(445);
		conta.setTitular("Pedro");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();	
		em.persist(conta);
	}

}
