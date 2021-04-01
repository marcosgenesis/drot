package br.com.pi.drot.models;

public class NomeMedicoLogado {
	private String nomeMedico;

	public String getNomeMedico() {
		return nomeMedico;
	}

	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}

	public NomeMedicoLogado(){}

	public NomeMedicoLogado(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}

	@Override
	public String toString() {
		return "NomeMedicoLogado [nomeMedico=" + nomeMedico + "]";
	}


}
