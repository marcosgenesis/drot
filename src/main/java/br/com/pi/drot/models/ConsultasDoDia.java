package br.com.pi.drot.models;

public class ConsultasDoDia {
	private String nomePacienteConsulta;
	private String dataOcorreuConsulta;
	private String descricaoConsulta;
	private String classificacaoUrgencia;


	public ConsultasDoDia(String nomePacienteConsulta, String dataOcorreuConsulta, String descricaoConsulta, String classificacaoUrgencia) {
		this.nomePacienteConsulta = nomePacienteConsulta;
		this.dataOcorreuConsulta = dataOcorreuConsulta;
		this.descricaoConsulta = descricaoConsulta;
		this.classificacaoUrgencia = classificacaoUrgencia;
	}


	public String getNomePacienteConsulta() {
		return nomePacienteConsulta;
	}


	public void setNomePacienteConsulta(String nomePacienteConsulta) {
		this.nomePacienteConsulta = nomePacienteConsulta;
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


	public String getClassificacaoUrgencia() {
		return classificacaoUrgencia;
	}


	public void setClassificacaoUrgencia(String classificacaoUrgencia) {
		this.classificacaoUrgencia = classificacaoUrgencia;
	}


	@Override
	public String toString() {
		return "ConsultasDoDia [nomePacienteConsulta=" + nomePacienteConsulta + ", dataOcorreuConsulta="
				+ dataOcorreuConsulta + ", descricaoConsulta=" + descricaoConsulta + ", classificacaoUrgencia="
				+ classificacaoUrgencia + "]";
	}

}
