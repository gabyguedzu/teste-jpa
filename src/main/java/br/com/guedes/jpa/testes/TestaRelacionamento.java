package br.com.guedes.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.guedes.jpa.modelo.Conta;
import br.com.guedes.jpa.modelo.Movimentacao;
import br.com.guedes.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamento {
	
	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setTitular("Gaby");
		conta.setNumero(21241);
		conta.setSaldo(300.0);
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setDescricao("Churrascaria");
		movimentacao.setValor(new BigDecimal(200.0));
		movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		movimentacao.setConta(conta);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();	
		
		em.getTransaction().begin();
		em.persist(conta);
		em.persist(movimentacao);
		em.getTransaction().commit();
		
		em.close();		
	}

}