package br.com.pi.drot.dto;

import java.util.ArrayList;

import br.com.pi.drot.dao.TratamentoPacienteDAO;
import br.com.pi.drot.model.PacienteModel;
import br.com.pi.drot.model.TratamentoPacienteModel;

public class TratamentoPacienteDTO implements TratamentoPacienteDAO{

	@Override
	public boolean cadastrarTratamento(PacienteModel paciente, TratamentoPacienteModel tratamento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TratamentoPacienteModel buscarTratamentoPorID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TratamentoPacienteModel> listarTratamento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean editar(TratamentoPacienteModel tratamento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removerTratamentoPorId(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
