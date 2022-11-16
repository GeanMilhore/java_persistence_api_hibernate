package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.loja.modelo.Produto;

public class CadastroDeProduto {

	public static void main(String[] args) {
		
		Produto celular = new Produto();
		celular.setNome("Xiaomi Redmi");
		celular.setDescricao("Celular com 8 gb de ram");
		celular.setPreco(new BigDecimal("1250"));
		
							// nome do persistence unit | para saber qual banco de dados se conectar
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("loja"); 
		EntityManager em = emFactory.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(celular);
		
		em.getTransaction().commit();
		em.close();
	}
}
