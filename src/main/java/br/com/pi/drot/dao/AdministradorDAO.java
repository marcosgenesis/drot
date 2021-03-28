package br.com.pi.drot.dao;

import java.util.ArrayList;

import br.com.pi.drot.entity.Administrador;
import br.com.pi.drot.entity.Medico;
import br.com.pi.drot.entity.Paciente;
import br.com.pi.drot.entity.Secretaria;

public interface AdministradorDAO {

	 boolean cadastrarNovoAdministrador(String nome, String CPF, String RG, String dataNascimento, int endereco, String telefone, String email, String senha);

	 Administrador buscarAdministradorPorID(int id);

	 boolean cadastrarNovoPaciente(String nome, String CPF, String RG, String dataNascimento, int endereco, String telefone, String restricaoMedicamental, String doencaHereditaria, String email, String senha);

	 boolean editarPaciente(int idPaciente, int endereco, String telefone, String email, String senha);

	 Paciente buscarPacientePorID(int idPaciente);

	 ArrayList<Paciente> listarPacientesCadastrados();

	 boolean removerPaciente(int idPaciente);

	 boolean cadastrarNovoMedico(String nome, String CPF, String RG, String dataNascimento, int endereco, String telefone, String email, String senha);

	 boolean editarMedico(int idMedico, int endereco, String telefone, String email, String senha);

	 Medico buscarMedicoPorID(int idMedico);

	 ArrayList<Medico> listarMedicosCadastrados();

	 boolean removerMedico(int idMedico);

	 boolean cadastrarNovaSecretaria(String nome, String CPF, String RG, String dataNascimento, int endereco, String telefone, String email, String senha);

	 boolean editarSecretaria(int idSecretaria, int endereco, String telefone, String email, String senha);

	 Secretaria buscarSecretariaPorID(int idSecretaria);

	 ArrayList<Secretaria> listarSecretariasCadastrados();

	 boolean removerSecretaria(int idSecretaria);

	 boolean logado(String email, String pass);

}
