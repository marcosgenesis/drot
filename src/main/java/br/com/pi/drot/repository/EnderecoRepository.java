package br.com.pi.drot.repository;

import javax.persistence.NoResultException;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.EnderecoDAO;
import br.com.pi.drot.entity.Endereco;

public class EnderecoRepository implements EnderecoDAO{

	Connection connection = Connection.getInstance();

	public EnderecoRepository() {
	}


	public boolean cadastrarEndereco(String uf, String rua, int numero, String bairro, String cidade, String cep) {
		Endereco endereco = new Endereco();
		endereco.setUf(uf);
		endereco.setRua(rua);
		endereco.setNumero(numero);
		endereco.setBairro(bairro);
		endereco.setCidade(cidade);
		endereco.setCep(cep);
		this.connection.getEntityManager().getTransaction().begin();
		this.connection.getEntityManager().persist(endereco);
		this.connection.getEntityManager().getTransaction().commit();
		System.out.println("chegooou");

		return true;
	}
	public String pegarInformacoesEnderecoPorID(int id) {
        this.connection.getEntityManager().clear();

        try{
            Endereco endereco = this.connection.getEntityManager().createNamedQuery("Endereco.getById", Endereco.class).setParameter("id", id).getSingleResult();

            return endereco.toString();
        } catch(NoResultException ex) {
            System.out.println("Endereço não encontrado.");
            return null;
        }
    }
	public int pegarIdEndereco(String cep, int numero) {
		try {
			Endereco e = this.connection.getEntityManager().createNamedQuery("Endereco.getIdEndereco", Endereco.class).setParameter("numero", numero).setParameter("cep", cep).getSingleResult();

			return e.getId();
		} catch(NoResultException e) {
			return -1;

		}
	}

}
