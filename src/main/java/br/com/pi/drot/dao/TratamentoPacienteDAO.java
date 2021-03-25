package br.com.pi.drot.dao;

import java.util.ArrayList;

import br.com.pi.drot.model.PacienteModel;
import br.com.pi.drot.model.TratamentoPacienteModel;

public interface TratamentoPacienteDAO {

	boolean cadastrarTratamento(PacienteModel paciente, TratamentoPacienteModel tratamento);

	TratamentoPacienteModel buscarTratamentoPorID(int id);

	ArrayList<TratamentoPacienteModel> listarTratamento();

	boolean editar(TratamentoPacienteModel tratamento);

	boolean removerTratamentoPorId(int id);
}
