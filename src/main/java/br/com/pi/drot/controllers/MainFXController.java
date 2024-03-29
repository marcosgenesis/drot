package br.com.pi.drot.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.pi.drot.UI.MainFX;
import br.com.pi.drot.components.SideBarController;
import br.com.pi.drot.repository.RelatorioConsultasDoDiaRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class MainFXController extends SideBarController implements Initializable{

	@FXML
	private Button clickBtn;

	@FXML
	private Label userName;

	@FXML
	private Text numPacientesAtendidosHoje;

	@FXML
	private Text numPacientesNaEspera;

	@FXML
	private Button btnSwitchWindow;

	@FXML
	private void btnAction(ActionEvent event) {
		MainFX.chanceWindow("newPacientInQueue");
	}


	@FXML
	private void changeLogin(ActionEvent event) {
		System.out.println("teste");
		MainFX.chanceWindow("login");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		RelatorioConsultasDoDiaRepository relatorioConsultasDoDiaRepositorio = new RelatorioConsultasDoDiaRepository();
		numPacientesAtendidosHoje.setText(Integer.toString(relatorioConsultasDoDiaRepositorio.quantidadeConsultasRealizadasDoDia("")));
		numPacientesNaEspera.setText(Integer.toString(relatorioConsultasDoDiaRepositorio.quantidadeConsultasNaoRealizadasDoDia("")));


	}
}
