package br.com.pi.drot.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.pi.drot.model.AdministradorModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LoginFXController implements Initializable{

	@FXML
	private TextField loginUser;

	@FXML
	private TextField passUser;

	@FXML
	private void loginAccess(ActionEvent event) {
		//System.out.println(this.loginUser.getText());
		//System.out.println(this.passUser.getText());

		AdministradorModel admModel = new AdministradorModel();

		if(admModel.logado(this.loginUser.getText(), this.passUser.getText())){
			System.out.println("foi");
		}else{
			System.out.println("Nao foi");
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

}
