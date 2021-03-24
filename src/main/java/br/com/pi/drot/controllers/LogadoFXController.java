package br.com.pi.drot.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.pi.drot.UI.MainFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class LogadoFXController implements Initializable{

	@FXML
	private void logout(ActionEvent event) {
		MainFX.chanceWindow("login");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}
