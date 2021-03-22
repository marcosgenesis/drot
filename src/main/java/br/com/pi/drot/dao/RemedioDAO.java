package br.com.pi.drot.dao;

import java.util.ArrayList;

import br.com.pi.drot.entity.Remedio;
import br.com.pi.drot.entity.TratamentoPaciente;

public interface RemedioDAO {

	boolean cadastrarRemedio(TratamentoPaciente tratamento);

	Remedio buscarRemedioPorID(int id);

	ArrayList<Remedio> listarRemedio();

	boolean editar(Remedio remedio);

	boolean removerRemedioPorId(int id);
}
