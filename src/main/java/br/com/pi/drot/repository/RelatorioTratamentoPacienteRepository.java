package br.com.pi.drot.repository;

import java.util.ArrayList;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.RelatorioTratamentoPacienteDAO;
import br.com.pi.drot.entity.TratamentoPaciente;

public class RelatorioTratamentoPacienteRepository implements RelatorioTratamentoPacienteDAO {
	Connection connection = Connection.getInstance();

	public RelatorioTratamentoPacienteRepository() {}

	public ArrayList<TratamentoPaciente> listarTratamentosAtivos() {
		TratamentoPacienteRepository tratamento = new TratamentoPacienteRepository();

        ArrayList<TratamentoPaciente> tratamentos = tratamento.listarTratamentosPaciente();
        ArrayList<TratamentoPaciente> tratamentosAtivos = new ArrayList<TratamentoPaciente>();

        for(TratamentoPaciente t: tratamentos) {
            if(t.isEstadoTratamento()) {
                tratamentosAtivos.add(t);
            }
        }
        return tratamentosAtivos;
    }

	public int quantidadeTratamentos() {
		TratamentoPacienteRepository tratamento = new TratamentoPacienteRepository();
        ArrayList<TratamentoPaciente> tratamentos = tratamento.listarTratamentosPaciente();
        return tratamentos.size();
    }

    public int quantidadeTratamentosAtivos() {
        ArrayList<TratamentoPaciente> tratamentosAtivos = listarTratamentosAtivos();
        return tratamentosAtivos.size();
    }

}
