package br.com.pi.drot.models;

public class TratamentosPaciente {
	private String exame;
	private String remedio;
	private int tempoTratamento;

	public TratamentosPaciente(String exame, String remedio, int tempoTratamento) {
		this.exame = exame;
		this.remedio = remedio;
		this.tempoTratamento = tempoTratamento;
	}

	public String getExame() {
		return exame;
	}

	public void setExame(String exame) {
		this.exame = exame;
	}

	public String getRemedio() {
		return remedio;
	}

	public void setRemedio(String remedio) {
		this.remedio = remedio;
	}

	public int getTempoTratamento() {
		return tempoTratamento;
	}

	public void setTempoTratamento(int tempoTratamento) {
		this.tempoTratamento = tempoTratamento;
	}

	@Override
	public String toString() {
		return "TratamentosPaciente [exame=" + exame + ", remedio=" + remedio + ", tempoTratamento=" + tempoTratamento
				+ "]";
	}

}
