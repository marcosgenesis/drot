package br.com.pi.drot.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import br.com.pi.drot.UI.MainFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class NovoUsuarioFXController implements Initializable{

	@FXML
	private Button clickBtn;

	@FXML
	private void btnAction(ActionEvent event) {
		MainFX.chanceWindow("main");
	}

	public void initialize(URL location, ResourceBundle resources) {

	}

}

