package br.com.pi.drot.model;

public class RemedioModel{
	private int id;
	private String nomeRemedio;
	private String dosagem;
	private String bula;
	private String contraIndicacao;

	public RemedioModel(int id, String nomeRemedio, String dosagem, String bula, String contraIndicacao) {
		super();
		this.id = id;
		this.nomeRemedio = nomeRemedio;
		this.dosagem = dosagem;
		this.bula = bula;
		this.contraIndicacao = contraIndicacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeRemedio() {
		return nomeRemedio;
	}

	public void setNomeRemedio(String nomeRemedio) {
		this.nomeRemedio = nomeRemedio;
	}

	public String getDosagem() {
		return dosagem;
	}

	public void setDosagem(String dosagem) {
		this.dosagem = dosagem;
	}

	public String getBula() {
		return bula;
	}

	public void setBula(String bula) {
		this.bula = bula;
	}

	public String getContraIndicacao() {
		return contraIndicacao;
	}

	public void setContraIndicacao(String contraIndicacao) {
		this.contraIndicacao = contraIndicacao;
	}


}
