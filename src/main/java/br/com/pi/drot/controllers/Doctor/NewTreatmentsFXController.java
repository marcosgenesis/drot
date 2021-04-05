package br.com.pi.drot.controllers.Doctor;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.pi.drot.UI.MainFX;
import br.com.pi.drot.components.SideBarController;
import br.com.pi.drot.models.TratamentosPaciente;
import br.com.pi.drot.repository.PacienteRepository;
import br.com.pi.drot.repository.TratamentoPacienteRepository;
import br.com.pi.drot.utils.FormatadorMascara;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class NewTreatmentsFXController extends SideBarController implements Initializable {
	@FXML
	private TextField cpfPaciente;
	@FXML
	private TextField dataInicioTratamento;
	@FXML
	private TextField duracaoTratamentoEmDias;

	@FXML
	private void adicionarTratamento(ActionEvent event) {
		TratamentoPacienteRepository tratamentoRepositorio = new TratamentoPacienteRepository();
		PacienteRepository pacienteRepositorio = new PacienteRepository();
		tratamentoRepositorio.criarTratamentoPaciente(
				pacienteRepositorio.pegarIdPaciente(this.cpfPaciente.getText()),
				this.dataInicioTratamento.getText(),
				Integer.parseInt(this.duracaoTratamentoEmDias.getText())
				);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		FormatadorMascara maskCpf = new FormatadorMascara(cpfPaciente);
		maskCpf.setMask(FormatadorMascara.CPF);
		FormatadorMascara maskData = new FormatadorMascara(dataInicioTratamento);
		maskData.setMask(FormatadorMascara.DATA);
		
	}

}
