package br.com.pi.drot.utils;

import javax.persistence.NoResultException;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.entity.Teste;
import br.com.pi.drot.validations.CpfValidation;

public class TesteT {
	public static void main(String[] args) {
		if (CpfValidation.cpfValido("11111111111")) {
			System.out.println("Valido");
		} else {
			System.out.println("Nao Valido");
		}

		/*Connection connection = new Connection();

		Teste t1 = new Teste();
		t1.setName("eric");
		t1.setEmail("teste@teste");
		t1.setPass("qwe123");*/

		/*if (create(connection, t1)) {
			System.out.println("Criou");
		} else {
			System.out.println("Nao Criou");
		}*/

		//System.out.println(testeById(connection, 4));

		//System.out.println(testeByName(connection, "eric"));

		/*if (login(connection, "teste@teste", "qwe123")) {
			System.out.println("Logou");
		} else {
			System.out.println("Nao Logou");
		}*/
	}

	public static boolean create(Connection c, Teste t) {
		c.getEntityManager().getTransaction().begin();
		c.getEntityManager().persist(t);
		c.getEntityManager().getTransaction().commit();

		return true;
	}

	public static Teste testeById(Connection c, int id) {
		Teste t = c.getEntityManager().find(Teste.class, id);

		if (t != null) {
			return t;
		}

		return null;
	}

	public static Teste testeByName(Connection c, String name) {
		try {
			Teste t = c.getEntityManager().createNamedQuery("Teste.byName", Teste.class).setParameter("name", name).getSingleResult();

			return t;
		} catch (NullPointerException e) {
			return null;
		}
	}

	public static boolean login(Connection c, String email, String pass) {
		try {
			Teste t = c.getEntityManager().createNamedQuery("Teste.byLogin", Teste.class).setParameter("email", email).setParameter("pass", pass).getSingleResult();

			return true;
		} catch (NoResultException e) {
			return false;
		}
	}
}
