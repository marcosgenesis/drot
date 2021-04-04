package br.com.pi.drot.models;

import br.com.pi.drot.repository.PacienteRepository;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class PacienteModel {
	private final int id;
    private final SimpleStringProperty nome;
    private final SimpleStringProperty dataNascimento;
    private final SimpleIntegerProperty idade;
    private final SimpleStringProperty endereco;
    
    private static PacienteRepository pacienteR = new PacienteRepository();

    public PacienteModel(int id,String nome,String endereco,String dataNascimento) {
    	this.id = id;
        this.nome = new SimpleStringProperty(nome);
        this.dataNascimento = new SimpleStringProperty(dataNascimento);
        this.idade = new SimpleIntegerProperty(PacienteModel.pacienteR.pegarIdadePaciente(id));
        this.endereco = new SimpleStringProperty(endereco);
    }

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome.get();
	}

	public String getDataNascimento() {
		return dataNascimento.get();
	}

	public int getIdade() {
		return idade.get();
	}

	public String getEndereco() {
		return endereco.get();
	}
    
}
