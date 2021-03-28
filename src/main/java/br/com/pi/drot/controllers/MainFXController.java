package br.com.pi.drot.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import br.com.pi.drot.UI.MainFX;
import br.com.pi.drot.components.SideBarController;
//import br.com.pi.drot.entity.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class MainFXController extends SideBarController implements Initializable{

	@FXML
	private Button clickBtn;

	@FXML
	private Button btnSwitchWindow;

	@FXML
	private void btnAction(ActionEvent event) {
		JOptionPane.showMessageDialog(null, "O controller da tela funcionou!", "Controller implementado com sucesso", 0);
	}

	
	@FXML
	private void changeLogin(ActionEvent event) {
		System.out.println("teste");
		MainFX.chanceWindow("login");
	}

	public void initialize(URL location, ResourceBundle resources) {

	}

}
