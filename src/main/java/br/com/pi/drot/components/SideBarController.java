package br.com.pi.drot.components;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.pi.drot.UI.MainFX;
//import br.com.pi.drot.entity.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class SideBarController implements Initializable {

	@FXML
	private void btnSwitchControlPanel(ActionEvent event) {
		MainFX.chanceWindow("main");
	}
	@FXML
	private void btnSwitchPatientScreen(ActionEvent event) {
		MainFX.chanceWindow("patientsScene");
	}
	@FXML
	private void btnSwitchDoctorScreen(ActionEvent event) {
		MainFX.chanceWindow("doctorsScene");
	}
	
	@FXML
	private void btnSwitchNewPatientScreen(ActionEvent event) {
		MainFX.chanceWindow("newPatient");
	}
	

	public void initialize(URL location, ResourceBundle resources) {

	}

}
