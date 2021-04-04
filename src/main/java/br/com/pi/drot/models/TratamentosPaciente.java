package br.com.pi.drot.models;

import java.text.DecimalFormat;

import javax.persistence.Column;

import br.com.pi.drot.repository.PacienteRepository;
import br.com.pi.drot.repository.TratamentoPacienteRepository;
import br.com.pi.drot.utils.DataDoDia;

public class TratamentosPaciente {
	private int exame;
	private int remedio;
	private int tempoTratamento;
	private int duracaoDiasTratamento;
	private String dataInicioTratamento;
	private int idPaciente;

	public TratamentosPaciente(int exame, int remedio, int tempoTratamento,int idPaciente,String dataInicioTratamento,int duracaoDiasTratamento) {
		this.exame = exame;
		this.remedio = remedio;
		this.idPaciente = idPaciente;
		this.tempoTratamento = tempoTratamento;
		this.dataInicioTratamento= dataInicioTratamento;
		this.duracaoDiasTratamento= duracaoDiasTratamento;
	}
	public int getDuracaoDiasTratamento() {
		return duracaoDiasTratamento;
	}

	public void setDuracaoDiasTratamento(int duracaoDiasTratamento) {
		this.duracaoDiasTratamento = duracaoDiasTratamento;
	}

	public String getDataInicioTratamento() {
		return dataInicioTratamento;
	}

	public void setDataInicioTratamento(String dataInicioTratamento) {
		this.dataInicioTratamento = dataInicioTratamento;
	}
	public int getExame() {
		return exame;
	}

	public void setExame(int exame) {
		this.exame = exame;
	}

	public int getRemedio() {
		return remedio;
	}

	public void setRemedio(int remedio) {
		this.remedio = remedio;
	}

	public int getTempoTratamento() {
		return tempoTratamento;
	}

	public void setTempoTratamento(int tempoTratamento) {
		this.tempoTratamento = tempoTratamento;
	}
	
	public String getPorcentagemTratamentoString() {
		return new DecimalFormat("#,##0.00").format(getPorcentagemDouble()) + "%";
	}
	
	public String getNomePaciente() {
		PacienteRepository pacienteRepo = new PacienteRepository();
		return pacienteRepo.pegarNomePacienteLogado(idPaciente);
	}
	
	public Double getPorcentagemDouble() {
        DataDoDia dataDia = DataDoDia.getInstance();
        System.out.println("gertporcentagemdouble = " + dataDia.diferencaEmDiasAteHoje(dataInicioTratamento, duracaoDiasTratamento));
        System.out.println("duracaodiastratamento = " + duracaoDiasTratamento);
        Double diferenca = new Double(dataDia.diferencaEmDiasAteHoje(dataInicioTratamento, duracaoDiasTratamento));
        Double divisao = new Double(diferenca / duracaoDiasTratamento);
        Double resultado = new Double(divisao * 100);
        return resultado;
    }
	public int getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}
	@Override
	public String toString() {
		return "TratamentosPaciente [exame=" + exame + ", remedio=" + remedio + ", tempoTratamento=" + tempoTratamento
				+ "]";
	}

}
