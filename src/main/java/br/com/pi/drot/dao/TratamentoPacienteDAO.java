package br.com.pi.drot.dao;

import java.sql.Date;
import java.util.ArrayList;

import br.com.pi.drot.entity.Exame;
import br.com.pi.drot.entity.Paciente;
import br.com.pi.drot.entity.Remedio;
import br.com.pi.drot.entity.TratamentoPaciente;

public interface TratamentoPacienteDAO {

	boolean criarTratamentoPaciente(Paciente paciente, Remedio remedio, Exame exame, Date inicioTratamento, Date fimTratamento);

	TratamentoPaciente buscarTratamentoPacientePorID(int id);

	ArrayList<TratamentoPaciente> listarTratamentosPaciente();

	boolean editarTratamentoPacienteAdicionarRemedio(TratamentoPaciente tratamento, Remedio remedio);

	boolean editarTratamentoPacienteRemoverRemedio(TratamentoPaciente tratamento, Remedio remedio);

	boolean editarTratamentoPacienteAdicionarExame(TratamentoPaciente tratamento, Exame exame);

	boolean editarTratamentoPacienteRemoverExame(TratamentoPaciente tratamento, Exame exame);

	//boolean editarTratamentoPacienteAlterarFimTratamento(TratamentoPaciente tratamento, Date fimTratamento);

	boolean removerTratamentoṔaciente(TratamentoPaciente tratamento);

	boolean removerTratamentoPacientePorId(int id);

}
