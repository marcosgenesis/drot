package br.com.pi.drot;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.pi.drot.model.Cliente;

public class App {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BancoJPA");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();

	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		cliente.setNome("Teste");

		//entityManager.getTransaction().begin();
		//entityManager.persist(cliente);
		//entityManager.getTransaction().commit();

		cliente = entityManager.find(Cliente.class, 5);
		System.out.println("Nome do cliente: " + cliente.getNome());
	}
}
