package br.com.pi.drot.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.pi.drot.components.SideBarController;
import br.com.pi.drot.entity.Medico;
import br.com.pi.drot.models.MedicoModel;
import br.com.pi.drot.repository.ConsultaRepository;
import br.com.pi.drot.repository.PacienteRepository;
import br.com.pi.drot.repository.SecretariaRepository;
import br.com.pi.drot.utils.FormatadorMascara;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class NewPatientInQueueFXController extends SideBarController implements Initializable {
	ObservableList<String> consultorios = FXCollections.observableArrayList("Consultorio 01","Consultorio 02","Consultorio 03");
	ObservableList<String> classificacoes = FXCollections.observableArrayList("Emergência","Muito Urgente","Urgência", "Menos Graves","Leves");
	
	@FXML
	private ChoiceBox<Medico> medicoChoiceBox;
	@FXML
	private ChoiceBox<String> classificacaoUrgenciacChoiceBox;
	@FXML
	private ChoiceBox<String> consultoriosChoiceBox;
	@FXML
	private TextField cpfPaciente;
	@FXML
	private TextField descricaoSintomas;
	@FXML
	private void adicionarPaciente(ActionEvent event) {
		ConsultaRepository consultaRepo = new ConsultaRepository();
		PacienteRepository pacienteRepo = new PacienteRepository();
		consultaRepo.criarConsulta(
				pacienteRepo.pegarIdPaciente(cpfPaciente.getText()),
				medicoChoiceBox.getValue().getId(),
				descricaoSintomas.getText(),
				classificacaoUrgenciacChoiceBox.getValue(),
				false,
				consultoriosChoiceBox.getValue());
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		consultoriosChoiceBox.setValue(consultorios.get(0));
		classificacaoUrgenciacChoiceBox.setValue("Emergência");
		consultoriosChoiceBox.setItems(consultorios);
		classificacaoUrgenciacChoiceBox.setItems(classificacoes);
		
		SecretariaRepository secretariaRepo = new SecretariaRepository();
		medicoChoiceBox.setItems(FXCollections.observableList(secretariaRepo.listarMedicosCadastrados()));
		
		
	}
}
