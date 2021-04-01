package br.com.pi.drot.dao;

import java.util.ArrayList;

import br.com.pi.drot.models.ConsultasDoDia;

public interface SecretariaDAO {
	ArrayList<ConsultasDoDia> consultasDoDia(int idPaciente, String dataDoDia);
	String pegarnomeSecretariaLogada(int idSecretaria);
	int quantidadeConsultasDoDia(String dataDoDia);
	int quantidadeConsultasRealizadasDoDia(String dataDoDia);
	int quantidadeConsultasNaoRealizadasDoDia(String dataDoDia);
}
