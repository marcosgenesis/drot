package br.com.pi.drot.dao;

public interface EnderecoDAO {

	boolean cadastrarEndereco(String uf, String rua, int numero, String bairro, String cidade, String cep);

	int pegarIdEndereco(String cep, int numero);

}
