package br.com.pi.drot.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import br.com.pi.drot.components.SideBarController;
import br.com.pi.drot.repository.EnderecoRepository;
import br.com.pi.drot.repository.SecretariaRepository;
import br.com.pi.drot.utils.CriptografarSenha;
import br.com.pi.drot.utils.FormatadorCPF;
import br.com.pi.drot.utils.FormatadorMascara;
import br.com.pi.drot.validations.CpfValidation;
import br.com.pi.drot.validations.EmailValidation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

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
	void btnSwitchPatientScreen(ActionEvent event) {

	}

	@FXML
	void cadastrarPaciente(ActionEvent event) {
		if (this.nome.getText().equals("") || this.cpf.getText().equals("") || this.rg.getText().equals("") || this.dataNascimento.getText().equals("") || this.rua.getText().equals("") || this.numero.getText().equals("") || this.bairro.getText().equals("") || this.cidade.getText().equals("") || this.cep.getText().equals("") || this.email.getText().equals("") || this.senha.getText().equals("") ||	this.restricao.getText().equals("") || this.doenca.getText().equals("") || this.uf.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Insertion all inputs for login", "Input Invalid", 0);
			return;
		} else {
			if (!CpfValidation.cpfValido(FormatadorCPF.cleanCpf(this.cpf.getText()))) {
				JOptionPane.showMessageDialog(null, "These CPF for access not is valid", "CPF Invalid", 0);
			} else if (!EmailValidation.emailEValido(this.email.getText())) {
				JOptionPane.showMessageDialog(null, "These e-mail for access not is valid", "Email Invalid", 0);
			} else {
				SecretariaRepository secretaryRepository=  new SecretariaRepository();
				EnderecoRepository enderecoRepository = new EnderecoRepository();

				int idEnderecoExistente = enderecoRepository.pegarIdEndereco(this.cep.getText(), Integer.parseInt(this.numero.getText()));

				if (idEnderecoExistente != -1) {
					secretaryRepository.cadastrarNovoPaciente(this.nome.getText(),
							this.cpf.getText(),
							this.rg.getText(),
							this.dataNascimento.getText(),
							idEnderecoExistente,
							this.telefone.getText(),
							this.restricao.getText(),
							this.doenca.getText(),
							this.email.getText(),
							CriptografarSenha.criptografarSenha(this.senha.getText()));

					this.limparFormularioCadastroPaciente();
				} else {
					enderecoRepository.cadastrarEndereco(
							this.uf.getText(),
							this.rua.getText(),
							Integer.parseInt(this.numero.getText()),
							this.bairro.getText(),
							this.cidade.getText(),
							this.cep.getText()
					);
					int codEndereco = enderecoRepository.pegarIdEndereco(this.cep.getText(),Integer.parseInt(this.numero.getText()));

					secretaryRepository.cadastrarNovoPaciente(this.nome.getText(),
							this.cpf.getText(),
							this.rg.getText(),
							this.dataNascimento.getText(),
							codEndereco,
							this.telefone.getText(),
							this.restricao.getText(),
							this.doenca.getText(),
							this.email.getText(),
							CriptografarSenha.criptografarSenha(this.senha.getText()));

					this.limparFormularioCadastroPaciente();
				}
			}
		}
	}

	public void limparFormularioCadastroPaciente() {
		JOptionPane.showMessageDialog(null, "New patient adding with success!", "Patient add with success", 0);

		this.nome.setText("");
		this.cpf.setText("");
		this.rg.setText("");
		this.dataNascimento.setText("");
		this.rua.setText("");
		this.numero.setText("");
		this.bairro.setText("");
		this.cidade.setText("");
		this.cep.setText("");
		this.email.setText("");
		this.senha.setText("");
		this.restricao.setText("");
		this.doenca.setText("");
		this.uf.setText("");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		uf.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));

		FormatadorMascara mascaraCPF = new FormatadorMascara(cpf);
		mascaraCPF.setMask(FormatadorMascara.CPF);

		FormatadorMascara mascaraRG = new FormatadorMascara(rg);
		mascaraRG.setMask(FormatadorMascara.RG);

		FormatadorMascara mascaraTelefone = new FormatadorMascara(telefone);
		mascaraTelefone.setMask(FormatadorMascara.TEL_9DIG);

		FormatadorMascara mascaraCEP = new FormatadorMascara(cep);
		mascaraCEP.setMask(FormatadorMascara.CEP);

		FormatadorMascara mascaraDATA = new FormatadorMascara(dataNascimento);
		mascaraDATA.setMask(FormatadorMascara.DATA);

		FormatadorMascara mascaraUF = new FormatadorMascara(uf);
		mascaraUF.setMask(FormatadorMascara.UF);
	}

}
