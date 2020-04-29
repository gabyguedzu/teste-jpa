package br.com.guedes.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.guedes.jpa.modelo.Movimentacao;

public class TesteJQPL {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select m form Movimentacao m where m.conta.id = 1";
		
		Query createQuery = em.createQuery(jpql);
		List<Movimentacao> resultList = createQuery.getResultList();
		
		for (Movimentacao movimentacao : resultList) {
			System.out.println("Descrição >> " + movimentacao.getDescricao());
		}			
	}
}
