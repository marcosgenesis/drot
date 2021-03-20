package br.com.pi.drot.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.pi.drot.model.Cliente;
import br.com.pi.drot.model.Usuario;

public class Connection {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BancoJPA");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();

	public static void main(String[] args) {
		Usuario usuario = new Usuario(1, "Usuário Teste", null, null, null, null, null, false);

		//entityManager.getTransaction().begin();
		//entityManager.persist(cliente);
		//entityManager.getTransaction().commit();

		usuario = entityManager.find(Usuario.class, 5);
		System.out.println("Nome do cliente: " + usuario.getNome());
	}
}
