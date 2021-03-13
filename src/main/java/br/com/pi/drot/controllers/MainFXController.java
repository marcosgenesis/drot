package br.com.pi.drot.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class MainFXController implements Initializable{

	@FXML
	private Button clickBtn;

	@FXML
	private void btnAction(ActionEvent event) {
		JOptionPane.showMessageDialog(null, "O controller da tela funcionou!", "Controller implementado com sucesso", 0);
	}

	public void initialize(URL location, ResourceBundle resources) {

	}

}
