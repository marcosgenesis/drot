package br.com.pi.drot.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.pi.drot.UI.MainFX;
import br.com.pi.drot.components.SideBarController;
import br.com.pi.drot.repository.EnderecoRepository;
import br.com.pi.drot.repository.SecretariaRepository;
import br.com.pi.drot.utils.FormatadorMascara;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class NewDoctorFXController extends SideBarController implements Initializable {
	@FXML
	private TextField nome;

	@FXML
	private TextField cpf;

	@FXML
	private TextField rg;

	@FXML
	private TextField dataNascimento;

	@FXML
	private TextField telefone;

	@FXML
	private TextField rua;

	@FXML
	private TextField numero;

	@FXML
	private TextField bairro;

	@FXML
	private TextField cidade;

	@FXML
	private TextField cep;

	@FXML
	private TextField email;

	@FXML
	private TextField senha;

	@FXML
	private TextField restricao;

	@FXML
	private TextField doenca;

	@FXML
	private TextField uf;

	@FXML
	private void btnSwitchNewDoctorScreen(ActionEvent event) {
		MainFX.chanceWindow("newDoctor");
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		FormatadorMascara mascaraCPF = new FormatadorMascara(cpf);
		mascaraCPF.setMask(FormatadorMascara.CPF);
	}
	
	@FXML
	void cadastrarMedico(ActionEvent event) {
		SecretariaRepository secretaryRepository=  new SecretariaRepository();
		EnderecoRepository enderecoRepository = new EnderecoRepository();
		enderecoRepository.cadastrarEndereco(
				this.uf.getText(), 
				this.rua.getText(), 
				Integer.parseInt(this.numero.getText()),
				this.bairro.getText(),
				this.cidade.getText(),
				this.cep.getText()
		);
		int codEndereco = enderecoRepository.pegarIdEndereco(this.cep.getText(),Integer.parseInt(this.numero.getText()));
		secretaryRepository.cadastrarNovoMedico(this.nome.getText(), 
				this.cpf.getText(),
				this.rg.getText(), 
				this.dataNascimento.getText(),
				codEndereco, 
				this.telefone.getText(), 
				this.email.getText(),
				this.senha.getText());
	}
}
