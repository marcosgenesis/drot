package br.com.pi.drot.controllers;

import br.com.pi.drot.UI.MainFX;
import br.com.pi.drot.components.SideBarController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class NewPatientInQueueFXController extends SideBarController implements Initializable{
	@FXML
	private void btnSwitchNewPatientScreen(ActionEvent event) {
		MainFX.chanceWindow("newPatient");
	}
}
