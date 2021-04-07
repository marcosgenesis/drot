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
import br.com.pi.drot.repository.RelatorioConsultasMedicoRepository;
import br.com.pi.drot.repository.RelatorioTratamentoPacienteRepository;
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
import javafx.scene.layout.VBox;

public class TreatmentsFXController extends SideBarController implements Initializable{
	public int medicoLogado;
	@FXML
	private Button clickBtn;

	@FXML
	public Label numTratamentos;

	@FXML
	private ListView<TratamentosPaciente> tratamentosItens;

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
		RelatorioConsultasMedicoRepository relatorioConsultasMedicoRepositorio= new RelatorioConsultasMedicoRepository();
		System.out.println(relatorioConsultasMedicoRepositorio.quantidadeConsultasDiariasDoMedico(medicoLogado, ""));

		RelatorioTratamentoPacienteRepository relatorioTratamentoPacienteRepositorio= new RelatorioTratamentoPacienteRepository();

		TratamentoPacienteRepository tratamentoPacienteRepo = new TratamentoPacienteRepository();
		tratamentosObservableList = FXCollections.observableArrayList();
		for (TratamentoPaciente tratamento : tratamentoPacienteRepo.listarTratamentosPaciente()) {

			tratamentosObservableList.add(new TratamentosPaciente(
					tratamento.getExame(),tratamento.getDataInicioTratamento(),
					tratamento.getDuracaoDiasTratamento()
					));
		}
		tratamentosItens.setItems(tratamentosObservableList);
		tratamentosItens.setCellFactory(tratamentosItens -> new ItemTabelaTratamentosEmAndamento());
		numTratamentos.setText(Integer.toString(relatorioTratamentoPacienteRepositorio.quantidadeTratamentos()));

	}

}
