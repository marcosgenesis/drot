package br.com.pi.drot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Medicos")
public abstract class Medico extends Usuario{
	@Column(name = "CRF")
	private String CRF;

	@Column(name = "especialidade")
	private String especialidade;

	public String getCRF() {
		return CRF;
	}

	public void setCRF(String cRF) {
		CRF = cRF;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public void consultarPaciente() {}
	public void editarHistoricoPaciente() {}
	public void consultarHistoricoPaciente() {}
	public void criarTratamentodoPaciente() {}
	public void editarTratamentodoPaciente() {}

}
