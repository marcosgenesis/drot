package br.com.pi.drot.models;

import java.text.DecimalFormat;


import br.com.pi.drot.repository.PacienteRepository;
import br.com.pi.drot.utils.DataDoDia;

public class TratamentosPaciente {
	private int exame;
	private int remedio;
	private int tempoTratamento;
	private int duracaoDiasTratamento;
	private String dataInicioTratamento;
	private int idPaciente;
	private boolean estadoTratamento;


	public TratamentosPaciente(int exame, int remedio, int tempoTratamento,int idPaciente,String dataInicioTratamento,int duracaoDiasTratamento,boolean estadoTratamento) {
		this.exame = exame;
		this.remedio = remedio;
		this.idPaciente = idPaciente;
		this.tempoTratamento = tempoTratamento;
		this.dataInicioTratamento= dataInicioTratamento;
		this.duracaoDiasTratamento= duracaoDiasTratamento;
		this.estadoTratamento = estadoTratamento;
	}
	public int getDuracaoDiasTratamento() {
		return duracaoDiasTratamento;
	}

	public void setDuracaoDiasTratamento(int duracaoDiasTratamento) {
		this.duracaoDiasTratamento = duracaoDiasTratamento;
	}

	public boolean isEstadoTratamento() {
		return estadoTratamento;
	}
	public void setEstadoTratamento(boolean estadoTratamento) {
		this.estadoTratamento = estadoTratamento;
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
        Double diferenca = new Double(dataDia.diferencaEmDiasAteHoje(dataInicioTratamento, duracaoDiasTratamento));
        Double divisao = new Double(diferenca / duracaoDiasTratamento);
        Double resultado = new Double(divisao * 100);
        return resultado > 100.0 ? 100 : resultado;
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
