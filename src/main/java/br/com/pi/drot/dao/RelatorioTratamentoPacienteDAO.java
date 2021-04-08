package br.com.pi.drot.dao;

public interface RelatorioTratamentoPacienteDAO {
	ArrayList<TratamentoPaciente> listarTratamentosAtivos();

    int quantidadeTratamentos();

    int quantidadeTratamentosAtivos();

}
