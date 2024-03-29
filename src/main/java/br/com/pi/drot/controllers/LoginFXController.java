package br.com.pi.drot.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import br.com.pi.drot.UI.MainFX;
import br.com.pi.drot.components.SideBarController;
import br.com.pi.drot.controllers.Doctor.MainFXController;
import br.com.pi.drot.repository.AdministradorRepository;
import br.com.pi.drot.repository.MedicoRepository;
import br.com.pi.drot.repository.SecretariaRepository;
import br.com.pi.drot.utils.FormatadorCPF;
import br.com.pi.drot.utils.FormatadorMascara;
import br.com.pi.drot.validations.CpfValidation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginFXController extends SideBarController implements Initializable{

	ObservableList<String> userTypes = FXCollections.observableArrayList("Administrador","Médico","Secretária");

	@FXML
	private TextField loginUser;

	@FXML
	private PasswordField passUser;

	@FXML
	private ChoiceBox<String> userType;

	@FXML
	private Button btnLogin;

	@FXML
	private void loginAccess(ActionEvent event) {
		if (this.loginUser.getText().equals("") || this.passUser.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Insertion all inputs for login", "Input Invalid", 0);
			return;
		} else {
			if (!CpfValidation.cpfValido(FormatadorCPF.cleanCpf(this.loginUser.getText()))) {
				JOptionPane.showMessageDialog(null, "These CPF for access not is valid", "Email Invalid", 0);
			} else {

				switch(userType.getValue()){
					case "Administrador":{
						AdministradorRepository admRepo = new AdministradorRepository();
						if(admRepo.logado(this.loginUser.getText(), this.passUser.getText())){
							this.loginUser.setText("");
							this.passUser.setText("");
							MainFX.chanceWindow("main");
						}else{
							JOptionPane.showMessageDialog(null, "These data for access do not cross", "Fail Autenticad", 0);
							this.loginUser.setText("");
							this.passUser.setText("");
						}
						break;
					}
					case "Secretária":{
						SecretariaRepository secreRepo = new SecretariaRepository();
						if(secreRepo.logado(this.loginUser.getText(), this.passUser.getText())){
							this.loginUser.setText("");
							this.passUser.setText("");

							MainFX.chanceWindow("main");
						}else{
							JOptionPane.showMessageDialog(null, "These data for access do not cross", "Fail Autenticad", 0);
							this.loginUser.setText("");
							this.passUser.setText("");
						}
						break;
					}
					case "Médico":{
						MedicoRepository medicoRepo = new MedicoRepository();
						if(medicoRepo.logado(this.loginUser.getText(), this.passUser.getText())){
							MainFXController doctorController =  new MainFXController();
							doctorController.medicoLogado = medicoRepo.buscarIdMedicoPorCPF(this.loginUser.getText());
							this.loginUser.setText("");
							this.passUser.setText("");
							MainFX.chanceWindow("mainDoctorScene");
						}else{
							JOptionPane.showMessageDialog(null, "These data for access do not cross", "Fail Autenticad", 0);
							this.loginUser.setText("");
							this.passUser.setText("");
						}
						break;
					}
				}

			}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		userType.setValue("Administrador");
		userType.setItems(userTypes);

		FormatadorMascara maskCpf = new FormatadorMascara(loginUser);
		maskCpf.setMask(FormatadorMascara.CPF);
	}

}
