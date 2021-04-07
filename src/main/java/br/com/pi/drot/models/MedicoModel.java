package br.com.pi.drot.models;

import br.com.pi.drot.repository.MedicoRepository;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class MedicoModel {
	private final int id;
    private final SimpleStringProperty nome;
    private final SimpleStringProperty cpf;
    private final SimpleIntegerProperty numPacientes;
    private final SimpleIntegerProperty numConsultasHoje;
    
    private static MedicoRepository medicoR = new MedicoRepository();

    public MedicoModel(int id,String nome,String cpf) {
    	this.id = id;
        this.nome = new SimpleStringProperty(nome);
        this.cpf = new SimpleStringProperty(cpf);
        this.numPacientes = new SimpleIntegerProperty(MedicoModel.medicoR.pegarNumPacientes(id));
        this.numConsultasHoje = new SimpleIntegerProperty(MedicoModel.medicoR.quantidadeConsultasDoDia(id,""));
    }

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome.get();
	}

	public String getCpf() {
		return cpf.get();
	}

	public int getNumPacientes() {
		return numPacientes.get();
	}

	public int getNumConsultasHoje() {
		return numConsultasHoje.get();
	}
}

	
    

