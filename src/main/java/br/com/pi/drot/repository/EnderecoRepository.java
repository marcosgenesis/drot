package br.com.pi.drot.repository;

import javax.persistence.NoResultException;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.EnderecoDAO;
import br.com.pi.drot.entity.Endereco;

public class EnderecoRepository implements EnderecoDAO{

	Connection connection = Connection.getConnection();

	public EnderecoRepository() {}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection conexao) {
		this.connection = Connection.getConnection();
		this.connection = conexao;
	}

	public boolean cadastrarEndereco(String uf, String rua, int numero, String bairro, String cidade, String cep) {
		Endereco endereco = new Endereco();
		endereco.setUf(uf);
		endereco.setRua(rua);
		endereco.setNumero(numero);
		endereco.setBairro(bairro);
		endereco.setCidade(cidade);
		endereco.setCep(cep);

		this.getConnection().getEntityManager().getTransaction().begin();
		this.getConnection().getEntityManager().persist(endereco);
		this.getConnection().getEntityManager().getTransaction().commit();
		this.getConnection().getEntityManager().close();

		System.out.println("Vai cão!");

		return true;
	}

	public int pegarIdEndereco(String cep, int numero) {
		try {
			Endereco e = this.getConnection().getEntityManager().createNamedQuery("Endereco.getIdEndereco", Endereco.class).setParameter("numero", numero).setParameter("cep", cep).getSingleResult();

			return e.getId();
		} catch(NoResultException e) {
			return -1;

		}
	}

}
