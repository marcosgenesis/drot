package br.com.pi.drot.dao;

import java.util.ArrayList;

import br.com.pi.drot.repository.RemedioRepository;
import br.com.pi.drot.repository.TratamentoPacienteRepository;

public interface RemedioDAO {

	boolean cadastrarRemedio(TratamentoPacienteRepository tratamento);

	RemedioRepository buscarRemedioPorID(int id);

	ArrayList<RemedioRepository> listarRemedio();

	boolean editar(RemedioRepository remedio);

	boolean removerRemedioPorId(int id);
}
