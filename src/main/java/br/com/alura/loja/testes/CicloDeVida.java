package br.com.alura.loja.testes;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.util.JPAUtil;

public class CicloDeVida {

	public static void main(String[] args) {
		
		/**
		 *  Ciclo de vida das entidades
		 *  
		 *  sempre que estanciamos uma entidade
		 *  ela não esta salva no banco de dados ainda.
		 *  
		 *  estados jpa
		 *  1 - (new) transient ( objeto java puro )
		 *  2 - (persist) gerenciado pela jpa ( sincronizado com banco de dados ) flush não comita mas sincroniza
		 *  
		 * 
		 */
		
		Categoria celulares = new Categoria("CELULARES");
		
		EntityManager em = JPAUtil.getEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(celulares);
		celulares.setNome("XPTO");
		
		em.flush();
		em.clear();
		
		celulares = em.merge(celulares); // devolve nova referência mas não muda o estado da entidade passada e sim retorna
										// uma nova referencia
		celulares.setNome("Cellphone");
		em.flush();
		em.clear();
		em.remove(celulares);
		em.flush();
		
		/**
		 * sempre que closed
		 * uma entidade muda de estado
		 * 
		 * detached - destacado
		 * entidade não é mais transient 
		 * ( entidade não esta mais sendo gerenciada )
		 * então alterações nela não disparam mais nenhum script sql no commit
		 */
	}
}
