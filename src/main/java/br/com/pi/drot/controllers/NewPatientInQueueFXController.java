package br.com.pi.drot.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.pi.drot.UI.MainFX;
import br.com.pi.drot.components.SideBarController;
import br.com.pi.drot.utils.FormatadorMascara;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

public class NewPatientInQueueFXController extends SideBarController implements Initializable{
	@FXML
	private void btnSwitchNewPatientScreen(ActionEvent event) {
		MainFX.chanceWindow("newPatient");
	}
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
    private TextField estado;

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
    private TextField restricaoMedica;

    @FXML
    private TextField disfuncoesHereditarias;

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
    void finalizarCadastro(ActionEvent event) {
    	
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//    	FormatadorMascara mascaraCEP = new FormatadorMascara(cep);
//    	mascaraCEP.setMask(FormatadorMascara.CEP);
//    	
//    	FormatadorMascara mascaraTelefone = new FormatadorMascara(telefone);
//    	mascaraTelefone.setMask(FormatadorMascara.TEL_9DIG);
//    	
//    	FormatadorMascara mascaraCPF = new FormatadorMascara(cpf);
//    	mascaraCPF.setMask(FormatadorMascara.CPF);
//
//        FormatadorMascara mascaraRG = new FormatadorMascara(rg);
//    	mascaraRG.setMask(FormatadorMascara.RG);
    	
    	


    }   
}
