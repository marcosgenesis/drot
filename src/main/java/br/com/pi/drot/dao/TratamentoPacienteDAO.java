package br.com.pi.drot.dao;

import java.util.ArrayList;

import br.com.pi.drot.entity.Exame;
import br.com.pi.drot.entity.Remedio;
import br.com.pi.drot.entity.TratamentoPaciente;

 public interface TratamentoPacienteDAO {

	boolean criarTratamentoPaciente(int idPaciente, int tempoTratamento);

	TratamentoPaciente buscarTratamentoPacientePorID(int idTratamento);

	ArrayList<TratamentoPaciente> listarTratamentosPaciente();

	boolean editarTratamentoPacienteAdicionarRemedio(int idTratamento, int idRemedio);

	boolean editarTratamentoPacienteRemoverRemedio(int idTratamento, int idRemedio);

	boolean editarTratamentoPacienteAdicionarExame(int idTratamento, int idExame);

	boolean editarTratamentoPacienteRemoverExame(int idTratamento, int idExame);

	boolean editarTratamentoPacienteAlterarTempoTratamento(int idTratamento, int tempoTratamento);

	boolean adicionarRemedio(Remedio remedio, int idTratamento);

	boolean removerTratamentoPacientePorId(int idTratamento);

	boolean adicionarExame(Exame exame, int idTratamento);

	Remedio buscarRemedioPorID(int id);

	boolean removerRemedioPorID(int idRemedio, int idTratamento);

	boolean removerExamePorID(Exame exame, int idTratamento);

	Exame buscarExamePorID(int id);

}
