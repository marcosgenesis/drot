package br.com.pi.drot.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import br.com.pi.drot.UI.MainFX;
import br.com.pi.drot.components.SideBarController;
import br.com.pi.drot.entity.Medico;
import br.com.pi.drot.entity.Paciente;
import br.com.pi.drot.models.MedicoModel;
import br.com.pi.drot.models.PacienteModel;
import br.com.pi.drot.repository.SecretariaRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DoctorsFXController extends SideBarController implements Initializable{

	@FXML
	private TableView<MedicoModel> tabelaMedicos;
	
	@FXML
    private TableColumn<MedicoModel,String> ColunaNome;
	
    @FXML
    private TableColumn<MedicoModel,String> ColunaCpf;
    
    @FXML
    private TableColumn<MedicoModel,Integer> ColunaNumPacientes;
    
    @FXML
    private TableColumn<MedicoModel,Integer> ColunaNumConsultasHoje;
	
	@FXML
	private void btnSwitchNewDoctorScreen(ActionEvent event) {
		MainFX.chanceWindow("newDoctor");
	}
	
	public void initialize(URL location, ResourceBundle resources) {
		SecretariaRepository secretariaRepositorio = new SecretariaRepository();

		
		ColunaNome.setCellValueFactory(
                new PropertyValueFactory<>("nome"));
        ColunaCpf.setCellValueFactory(
                new PropertyValueFactory<>("cpf"));
        ColunaNumConsultasHoje.setCellValueFactory(
                new PropertyValueFactory<>("numConsultasHoje"));
        ColunaNumPacientes.setCellValueFactory(
                new PropertyValueFactory<>("numPacientes"));
        
        tabelaMedicos.setItems(formataDadosPaciente(secretariaRepositorio));
		
	}
	
	private ObservableList<MedicoModel> formataDadosPaciente(SecretariaRepository secretariaRepositorio){
		ArrayList<Medico> lista = secretariaRepositorio.listarMedicosCadastrados();
		ArrayList<MedicoModel> pacientesComDadosFormatados = new ArrayList<>();
		
		for (Medico p : lista) {
			System.out.println("numero de pacientes: "+new MedicoModel(p.getId(), p.getNome(), p.getCPF()).getNumPacientes());
			pacientesComDadosFormatados.add(new MedicoModel(p.getId(), p.getNome(), p.getCPF()));
		}
		return FXCollections.observableList(pacientesComDadosFormatados);
	}

}
