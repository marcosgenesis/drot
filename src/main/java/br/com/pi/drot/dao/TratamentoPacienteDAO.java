package br.com.pi.drot.dao;

import java.util.ArrayList;

import br.com.pi.drot.model.PacienteRepository;
import br.com.pi.drot.model.TratamentoPacienteRepository;

public interface TratamentoPacienteDAO {

	boolean cadastrarTratamento(PacienteRepository paciente, TratamentoPacienteRepository tratamento);

	TratamentoPacienteRepository buscarTratamentoPorID(int id);

	ArrayList<TratamentoPacienteRepository> listarTratamento();

	boolean editar(PacienteRepository paciente, TratamentoPacienteRepository tratamento);

	boolean removerTratamentoPorId(int id);
}
