package br.com.pi.drot.dao;

import java.util.ArrayList;

import br.com.pi.drot.entity.Medico;

public interface MedicoDAO {
	boolean cadastrarNovoMedico(String nome, String CPF, String RG, String dataNascimento, int endereco, String telefone, String email, String senha);

	Medico buscarMedicoPorID(int idMedico);

	ArrayList<Medico> listarMedicosCadastrados();

	String pegarNomeMedicoLogado(int idMedico);

	boolean removerMedico(int idMedico);

	int buscarIdMedicoPorCPF(String cpf);

	boolean logado(String email, String pass);

}
