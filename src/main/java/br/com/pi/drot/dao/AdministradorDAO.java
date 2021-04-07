package br.com.pi.drot.dao;

import br.com.pi.drot.entity.Administrador;

public interface AdministradorDAO {
	 boolean cadastrarNovoAdministrador(String nome, String CPF, String RG, String dataNascimento, int endereco, String telefone, String email, String senha);

	 Administrador buscarAdministradorPorID(int id);

	 boolean logado(String email, String pass);
}
