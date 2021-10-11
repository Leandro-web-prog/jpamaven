package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		Pessoa p6 = new Pessoa(null, "Jim Morrison", "jim@bourbonstreeth.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(p6);
		em.getTransaction().commit();
		
		System.out.println(p6);
		
		
		Pessoa m = em.find(Pessoa.class, 20);
		em.getTransaction().begin();
		em.remove(m);
		em.getTransaction().commit();
		
		System.out.println("Pronto!");
		em.close();
		emf.close();
	}

}
