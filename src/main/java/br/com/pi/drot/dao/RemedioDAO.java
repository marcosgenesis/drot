package br.com.pi.drot.dao;

import java.util.ArrayList;

import br.com.pi.drot.model.RemedioRepository;
import br.com.pi.drot.model.TratamentoPacienteRepository;

public interface RemedioDAO {

	boolean cadastrarRemedio(TratamentoPacienteRepository tratamento);

	RemedioRepository buscarRemedioPorID(int id);

	ArrayList<RemedioRepository> listarRemedio();

	boolean editar(RemedioRepository remedio);

	boolean removerRemedioPorId(int id);
}
