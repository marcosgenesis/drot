package br.com.pi.drot.models;

public class ConsultasMedico {
	private String nomePacienteConsulta;
	private String dataOcorreuConsulta;
	private String descricaoConsulta;

	public ConsultasMedico(String nomePacienteConsulta, String dataOcorreuConsulta, String descricaoConsulta) {
		this.nomePacienteConsulta = nomePacienteConsulta;
		this.dataOcorreuConsulta = dataOcorreuConsulta;
		this.descricaoConsulta = descricaoConsulta;
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

	@Override
	public String toString() {
		return "ConsultasMedico [nomePacienteConsulta=" + nomePacienteConsulta + ", dataOcorreuConsulta="
				+ dataOcorreuConsulta + ", descricaoConsulta=" + descricaoConsulta + "]";
	}

}
