package br.com.pi.drot.dao;

import java.util.ArrayList;

import br.com.pi.drot.entity.Exame;
import br.com.pi.drot.entity.Remedio;
import br.com.pi.drot.entity.TratamentoPaciente;

 public interface TratamentoPacienteDAO {

	boolean criarTratamentoPaciente(int idPaciente, String dataInicioTratamento, int tempoTratamento);

	TratamentoPaciente buscarTratamentoPacientePorID(int idTratamento);

	ArrayList<TratamentoPaciente> listarTratamentosPaciente();

	boolean editarTratamentoPacienteAdicionarRemedio(int idTratamento, int idRemedio);

	boolean editarTratamentoPacienteAdicionarExame(int idTratamento, int idExame);

	boolean editarTratamentoPacienteAlterarTempoTratamento(int idTratamento, int tempoTratamento);

	boolean removerTratamentoPacientePorId(int idTratamento);

	boolean adicionarRemedio(int remedio, int idTratamento);

	boolean adicionarExame(int exame, int idTratamento);

	Remedio buscarRemedioPorID(int id);

	Exame buscarExamePorID(int id);

}
