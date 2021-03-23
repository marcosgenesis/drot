package br.com.pi.drot.dao;

import java.util.ArrayList;

import br.com.pi.drot.model.AdministradorModel;
import br.com.pi.drot.model.MedicoModel;
import br.com.pi.drot.model.PacienteModel;
import br.com.pi.drot.model.SecretariaModel;

public interface AdministradorDAO {

	 boolean cadastrarNovoAdministrador(AdministradorModel administrador);

	 boolean editarAdministrador(AdministradorModel administrador);

	 AdministradorModel buscarAdministradorPorID(int id);

	 ArrayList<AdministradorModel> listarAdministradoresCadastrados();

	 boolean cadastrarNovoPaciente(PacienteModel paciente);

	 boolean editarPaciente(PacienteModel paciente);

	 PacienteModel buscarPacientePorID(int id);

	 ArrayList<PacienteModel> listarPacientesCadastrados();

	 boolean removerPaciente(PacienteModel paciente);

	 boolean removerPacientePorId(int id);

	 boolean cadastrarNovoMedico(MedicoModel medico);

	 boolean editarMedico(MedicoModel medico);

	 MedicoModel buscarMedicoPorID(int id);

	 ArrayList<MedicoModel> listarMedicosCadastrados();

	 boolean removerMedico(MedicoModel medico);

	 boolean removerMedicoPorId(int id);

	 boolean cadastrarNovaSecretaria(SecretariaModel secretaria);

	 boolean editarSecretaria(SecretariaModel secretaria);

	 SecretariaModel buscarSecretariaPorID(int id);

	 ArrayList<SecretariaModel> listarSecretariasCadastrados();

	 boolean removerSecretaria(SecretariaModel secretaria);

	 boolean removerSecretariaPorId(int id);

	 AdministradorModel isAutentico(int id, String senha);

	 AdministradorModel obterAdministrador(int id);
}
