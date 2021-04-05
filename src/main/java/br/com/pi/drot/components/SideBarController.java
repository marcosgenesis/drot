package br.com.pi.drot.components;

import java.net.URL;
import java.util.ResourceBundle;


import br.com.pi.drot.UI.MainFX;
import br.com.pi.drot.controllers.EssentialsFXController;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
//import br.com.pi.drot.entity.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class SideBarController{

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
	private void btnSwitchDoctorPactientsScreen(ActionEvent event) {
		MainFX.chanceWindow("doctorPatientsScene");
	}
	
	@FXML
	private void btnSwitchMainDoctorScreen(ActionEvent event) {
		MainFX.chanceWindow("mainDoctorScene");
	}
	
	@FXML
	private void btnSwitchTreatmentScreen(ActionEvent event) {
		MainFX.chanceWindow("doctorTreatmentsScene");
	}

	@FXML
	private void btnSwitchNewPatientScreen(ActionEvent event) {
		System.out.println("tela de novo adress");
		MainFX.chanceWindow("newPatient");

	}
	
}
