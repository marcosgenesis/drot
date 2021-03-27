package br.com.pi.drot.dao;

import java.sql.Date;
import java.util.ArrayList;

import br.com.pi.drot.entity.Administrador;
import br.com.pi.drot.entity.Medico;
import br.com.pi.drot.entity.Paciente;
import br.com.pi.drot.entity.Secretaria;

public interface AdministradorDAO {

	 boolean cadastrarNovoAdministrador(String nome, String CPF, String RG, Date dataNascimento, String endereco, String telefone, String email, String senha);

	 boolean editarAdministrador(Administrador administrador);

	 Administrador buscarAdministradorPorID(int id);

	 ArrayList<Administrador> listarAdministradoresCadastrados();

	 boolean cadastrarNovoPaciente(Paciente paciente);

	 boolean editarPaciente(Paciente paciente);

	 Paciente buscarPacientePorID(int id);

	 ArrayList<Paciente> listarPacientesCadastrados();

	 boolean removerPaciente(Paciente paciente);

	 boolean removerPacientePorId(int id);

	 boolean cadastrarNovoMedico(String nome, String CPF, String RG, Date dataNascimento, String endereco, String telefone, String email, String senha);

	 boolean editarMedico(Medico medico);

	 Medico buscarMedicoPorID(int id);

	 ArrayList<Medico> listarMedicosCadastrados();

	 boolean removerMedico(Medico medico);

	 boolean removerMedicoPorId(int id);

	 boolean cadastrarNovaSecretaria(Secretaria secretaria);

	 boolean editarSecretaria(Secretaria secretaria);

	 Secretaria buscarSecretariaPorID(int id);

	 ArrayList<Secretaria> listarSecretariasCadastrados();

	 boolean removerSecretaria(Secretaria secretaria);

	 boolean removerSecretariaPorId(int id);

	 boolean logado(String email, String pass);

}
