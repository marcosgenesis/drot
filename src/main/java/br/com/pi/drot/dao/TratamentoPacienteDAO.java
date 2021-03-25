package br.com.pi.drot.dao;

import java.util.ArrayList;

import br.com.pi.drot.entity.Paciente;
import br.com.pi.drot.entity.TratamentoPaciente;

public interface TratamentoPacienteDAO {

	boolean cadastrarTratamento(Paciente paciente);

	TratamentoPaciente buscarTratamentoPorID(int id);

	ArrayList<TratamentoPaciente> listarTratamento();

	boolean editarTratamentoPaciente(Paciente paciente, TratamentoPaciente tratamento);

	boolean removerTratamentoPorId(int id);
}
