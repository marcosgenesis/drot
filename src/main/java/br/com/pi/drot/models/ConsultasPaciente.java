package br.com.pi.drot.models;

public class ConsultasPaciente {
	private String dataOcorreuConsulta;
	private String descricaoConsulta;
	private String classificacaoUrgencia;


	public ConsultasPaciente(String nomePacienteConsulta, String dataOcorreuConsulta, String descricaoConsulta, String classificacaoUrgencia) {
		this.dataOcorreuConsulta = dataOcorreuConsulta;
		this.descricaoConsulta = descricaoConsulta;
		this.classificacaoUrgencia = classificacaoUrgencia;
	}

	public String getClassificacaoUrgencia() {
		return classificacaoUrgencia;
	}

	public void setClassificacaoUrgencia(String classificacaoUrgencia) {
		this.classificacaoUrgencia = classificacaoUrgencia;
	}

	public String getDataOcorreuConsulta() {
		return dataOcorreuConsulta;
	}

	public void setDataOcorreuConsulta(String dataOcorreuConsulta) {
		this.dataOcorreuConsulta = dataOcorreuConsulta;
	}

	public String getDescricaoConsulta() {
		return descricaoConsulta;
	}

	public void setDescricaoConsulta(String descricaoConsulta) {
		this.descricaoConsulta = descricaoConsulta;
	}

	@Override
	public String toString() {
		return "ConsultasPaciente [dataOcorreuConsulta=" + dataOcorreuConsulta + ", descricaoConsulta="
				+ descricaoConsulta + ", classificacaoUrgencia=" + classificacaoUrgencia + "]";
	}

}
