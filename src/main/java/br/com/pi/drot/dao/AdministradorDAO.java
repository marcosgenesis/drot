package br.com.pi.drot.dao;

import java.util.ArrayList;

import br.com.pi.drot.entity.Administrador;
import br.com.pi.drot.entity.Medico;
import br.com.pi.drot.entity.Paciente;
import br.com.pi.drot.entity.Secretaria;

public interface AdministradorDAO {

	 boolean cadastrarNovoAdministrador(String nome, String CPF, String RG, String dataNascimento, int endereco, String telefone, String email, String senha);

	 Administrador buscarAdministradorPorID(int id);

	 boolean cadastrarNovaSecretaria(String nome, String CPF, String RG, String dataNascimento, int endereco, String telefone, String email, String senha);

	 Secretaria buscarSecretariaPorID(int idSecretaria);

	 String buscarNomeSecretariaPorID(int idSecretaria);

	 ArrayList<Secretaria> listarSecretariasCadastrados();

	 boolean removerSecretaria(int idSecretaria);

	 boolean logado(String email, String pass);

}
