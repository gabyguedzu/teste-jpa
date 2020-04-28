package br.com.guedes.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.guedes.jpa.modelo.Categoria;
import br.com.guedes.jpa.modelo.Conta;
import br.com.guedes.jpa.modelo.Movimentacao;
import br.com.guedes.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamentoMovimentacaoCategoria {

	public static void main(String[] args) {
		Categoria categoria = new Categoria("viagem");
		Categoria categoria2 = new Categoria("negocios");

		Conta conta = new Conta();
		conta.setId(2L);

		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setDescricao("viagem a SP");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setValor(new BigDecimal(300.0));
		movimentacao.setCategoria(Arrays.asList(categoria, categoria2));
		movimentacao.setConta(conta);

		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setDescricao("viagem a RJ");
		movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao2.setData(LocalDateTime.now());
		movimentacao2.setValor(new BigDecimal(400.0));
		movimentacao.setConta(conta);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();	
		
		em.getTransaction().begin();
		em.persist(categoria);
		em.persist(categoria2);
		em.persist(movimentacao);
		em.persist(movimentacao2);
		em.getTransaction().commit();
		
		em.close();		
	}

}
