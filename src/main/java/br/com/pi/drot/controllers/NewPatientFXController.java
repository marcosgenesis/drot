package br.com.pi.drot.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.pi.drot.components.SideBarController;
import br.com.pi.drot.utils.FormatadorMascara;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class NewPatientFXController extends SideBarController implements Initializable {

	@FXML
	private Button clickBtn;

	@FXML
	private Button clickBtn1;

	@FXML
	private Button clickBtn11;

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
	void btnSwitchControlPanel(ActionEvent event) {

	}

	@FXML
	void btnSwitchDoctorScreen(ActionEvent event) {

	}

	@FXML
	void btnSwitchNewPatientScreen(ActionEvent event) {

	}

	@FXML
	void btnSwitchPatientScreen(ActionEvent event) {

	}

	@FXML
	void cadastrarPaciente(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		FormatadorMascara mascaraCPF = new FormatadorMascara(cpf);
		mascaraCPF.setMask(FormatadorMascara.CPF);
	}

}
