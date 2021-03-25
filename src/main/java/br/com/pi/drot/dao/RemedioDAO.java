package br.com.pi.drot.dao;

import java.util.ArrayList;

import br.com.pi.drot.model.RemedioModel;
import br.com.pi.drot.model.TratamentoPacienteModel;

public interface RemedioDAO {

	boolean cadastrarRemedio(TratamentoPacienteModel tratamento);

	RemedioModel buscarRemedioPorID(int id);

	ArrayList<RemedioModel> listarRemedio();

	boolean editar(RemedioModel remedio);

	boolean removerRemedioPorId(int id);
}
