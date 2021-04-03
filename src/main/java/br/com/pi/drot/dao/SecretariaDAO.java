package br.com.pi.drot.dao;

import java.util.ArrayList;

import br.com.pi.drot.entity.Medico;
import br.com.pi.drot.models.ConsultasDoDia;

public interface SecretariaDAO {
	ArrayList<ConsultasDoDia> consultasDoDia(int idPaciente, String dataDoDia);

	String pegarnomeSecretariaLogada(int idSecretaria);

	int quantidadeConsultasDoDia(String dataDoDia);

	int quantidadeConsultasRealizadasDoDia(String dataDoDia);

	int quantidadeConsultasNaoRealizadasDoDia(String dataDoDia);

	boolean cadastrarNovoMedico(String nome, String CPF, String RG, String dataNascimento, int endereco, String telefone, String email, String senha);

	Medico buscarMedicoPorID(int idMedico);

	String buscarNomeMedicoPorID(int idMedico);

	ArrayList<Medico> listarMedicosCadastrados();

	boolean removerMedico(int idMedico);

}
