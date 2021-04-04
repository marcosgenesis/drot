package br.com.pi.drot.controllers.Doctor;

import java.net.URL;
import java.util.ResourceBundle;


import br.com.pi.drot.UI.MainFX;
import br.com.pi.drot.components.SideBarController;
import br.com.pi.drot.components.ListItem.ItemTabelaConsultaJaAtendida;
import br.com.pi.drot.components.ListItem.ItemTabelaTratamentosEmAndamento;
import br.com.pi.drot.entity.TratamentoPaciente;
import br.com.pi.drot.models.ConsultasMedico;
import br.com.pi.drot.models.TratamentosPaciente;
import br.com.pi.drot.repository.MedicoRepository;
import br.com.pi.drot.repository.TratamentoPacienteRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import br.com.pi.drot.entity.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class MainFXController extends SideBarController implements Initializable{
	public int medicoLogado;
	@FXML
	private Button clickBtn;
	
	@FXML
	public Label numPacientesAtendidosHoje;

	@FXML
	private ListView<ConsultasMedico> vitens;
	
	@FXML
	private ListView<TratamentosPaciente> tratamentosItens;
	
	private ObservableList<ConsultasMedico> consultasObservableList;
	private ObservableList<TratamentosPaciente> tratamentosObservableList;
	
	@FXML
	private VBox treatmentItems = null;
	
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

	public void initialize(URL location, ResourceBundle resources) {
		MedicoRepository medicoRepo = new MedicoRepository();
		System.out.println(medicoRepo.quantidadeConsultasDoDia(medicoLogado, ""));
		consultasObservableList = FXCollections.observableArrayList();
		for (ConsultasMedico consultaMedico : medicoRepo.consultasRealizadas(2)) {
			consultasObservableList.add(
					new ConsultasMedico(
							consultaMedico.getNomePacienteConsulta(),
							consultaMedico.getDataOcorreuConsulta(),
							consultaMedico.getDescricaoConsulta(),
							consultaMedico.getStatusConsulta()
					));
		}
		vitens.setItems(consultasObservableList);
		vitens.setCellFactory(vitens -> new ItemTabelaConsultaJaAtendida());
		
		TratamentoPacienteRepository tratamentoPacienteRepo = new TratamentoPacienteRepository();
		tratamentosObservableList = FXCollections.observableArrayList();
		for (TratamentoPaciente tratamento : tratamentoPacienteRepo.listarTratamentosPaciente()) {
		
			tratamentosObservableList.add(new TratamentosPaciente(
					tratamento.getExame(),tratamento.getRemedio(),
					tratamento.getTempoTratamento(),
					tratamento.getPaciente(),
					tratamento.getDataInicioTratamento(),
					tratamento.getDuracaoDiasTratamento()
					));
		}
		tratamentosItens.setItems(tratamentosObservableList);
		tratamentosItens.setCellFactory(tratamentosItens -> new ItemTabelaTratamentosEmAndamento());
		
	}

}
