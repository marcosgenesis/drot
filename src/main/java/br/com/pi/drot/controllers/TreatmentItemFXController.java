package br.com.pi.drot.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.pi.drot.UI.MainFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class TreatmentItemFXController implements Initializable{
	@FXML
	private void btnSwitchNewDoctorScreen(ActionEvent event) {
		MainFX.chanceWindow("newDoctor");
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}

