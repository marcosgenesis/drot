package br.com.pi.drot.dao;

import java.util.ArrayList;

import br.com.pi.drot.entity.Secretaria;

public interface SecretariaDAO {

	boolean cadastrarNovaSecretaria(String nome, String CPF, String RG, String dataNascimento, int endereco, String telefone, String email, String senha);
	Secretaria buscarSecretariaPorID(int id);
	ArrayList<Secretaria> listarSecretariasCadastrados();
	boolean removerSecretaria(int idSecretaria);
	boolean logado(String email, String pass);
}
