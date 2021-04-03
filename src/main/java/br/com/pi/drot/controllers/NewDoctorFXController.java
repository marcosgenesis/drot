package br.com.pi.drot.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.pi.drot.UI.MainFX;
import br.com.pi.drot.components.SideBarController;
import br.com.pi.drot.utils.FormatadorMascara;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class NewDoctorFXController extends SideBarController implements Initializable {

	@FXML
	private TextField cpf;

	@FXML
	private void btnSwitchNewDoctorScreen(ActionEvent event) {
		MainFX.chanceWindow("newDoctor");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		FormatadorMascara mascaraCPF = new FormatadorMascara(cpf);
		mascaraCPF.setMask(FormatadorMascara.CPF);
	}
}
