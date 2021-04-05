package br.com.pi.drot.components;



import br.com.pi.drot.UI.MainFX;
//import br.com.pi.drot.entity.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

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
	
	@FXML
	private void btnSwitchNeTreatmentScreen(ActionEvent event) {
		MainFX.chanceWindow("newTreatmentScreen");

	}
	
}
