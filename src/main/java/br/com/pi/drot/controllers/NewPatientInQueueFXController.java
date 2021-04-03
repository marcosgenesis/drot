package br.com.pi.drot.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import br.com.pi.drot.UI.MainFX;
import br.com.pi.drot.components.SideBarController;
import br.com.pi.drot.repository.AdministradorRepository;
import br.com.pi.drot.repository.EnderecoRepository;
import br.com.pi.drot.repository.PacienteRepository;
import br.com.pi.drot.utils.FormatadorMascara;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class NewPatientInQueueFXController extends SideBarController implements Initializable{
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
    void cadastrarPaciente(ActionEvent event) {
    	EnderecoRepository enderecoRepository = new EnderecoRepository();

    	enderecoRepository.cadastrarEndereco(uf.getText(), rua.getText(), Integer.parseInt(numero.getText()), bairro.getText(), cidade.getText(), cep.getText());
    	int idEndereco = enderecoRepository.pegarIdEndereco(cep.getText(), Integer.parseInt(numero.getText()));

    	System.out.println(idEndereco);

    	AdministradorRepository administradorRepository = new AdministradorRepository();
    	if(administradorRepository.cadastrarNovoPaciente(nome.getText(), cpf.getText(), rg.getText(), dataNascimento.getText(), idEndereco, telefone.getText(), restricao.getText(), doenca.getText(), email.getText(), senha.getText())){
    		JOptionPane.showMessageDialog(null, "O paciente foi cadastrado com sucesso", "Registrado com sucesso", 0);
    	} else {
    		JOptionPane.showMessageDialog(null, "O paciente nao cadastrado", "Falha ao registrar", 0);
    	}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
