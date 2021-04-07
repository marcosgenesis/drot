package br.com.pi.drot.dao;

import java.util.ArrayList;

import br.com.pi.drot.entity.Paciente;

public interface PacienteDAO {
	boolean cadastrarNovoPaciente(String nome, String CPF, String RG, String dataNascimento, int endereco, String telefone, String restricaoMedicamental, String doencaHereditaria, String email, String senha);

	Paciente buscarPacientePorID(int idPaciente);

	ArrayList<Paciente> listarPacientesCadastrados();

	boolean editarPaciente(int idPaciente, int endereco, String telefone, String email, String senha);

	boolean removerPaciente(int idPaciente);

	String pegarNomePacienteLogado(int idPaciente);

	int pegarIdadePaciente(int idPaciente)
;}
