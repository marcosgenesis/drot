package br.com.pi.drot.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import br.com.pi.drot.UI.MainFX;
import br.com.pi.drot.components.SideBarController;
import br.com.pi.drot.repository.AdministradorRepository;
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
				AdministradorRepository admModel = new AdministradorRepository();
				

				if(admModel.logado(this.loginUser.getText(), this.passUser.getText())){
					this.loginUser.setText("");
					this.passUser.setText("");
					this.loggedUserName = "Marcos Gênesis";
					MainFX.chanceWindow("logado");
				}else{
					JOptionPane.showMessageDialog(null, "These data for access do not cross", "Fail Autenticad", 0);
					this.loginUser.setText("");
					this.passUser.setText("");
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
