package br.com.pi.drot.controllers.Doctor;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import br.com.pi.drot.components.SideBarController;
import br.com.pi.drot.entity.Paciente;
import br.com.pi.drot.models.PacienteModel;
import br.com.pi.drot.repository.MedicoRepository;
import br.com.pi.drot.repository.SecretariaRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PatientsFXController extends SideBarController implements Initializable {
	
	@FXML
	private TableView<PacienteModel> tabelaPacientes;
	
	@FXML
    private TableColumn<PacienteModel,String> colunaPaciente;
	
    @FXML
    private TableColumn<PacienteModel,String> colunaIdade;
    
    @FXML
    private TableColumn<PacienteModel,String> colunaDataNascimento;
    
    @FXML
    private TableColumn<PacienteModel,String> colunaEndereco;
	
	public void initialize(URL location, ResourceBundle resources) {
		MedicoRepository medicoRepo = new MedicoRepository();

		
		colunaDataNascimento.setCellValueFactory(
                new PropertyValueFactory<>("dataNascimento"));
        colunaPaciente.setCellValueFactory(
                new PropertyValueFactory<>("nome"));
        colunaIdade.setCellValueFactory(
                new PropertyValueFactory<>("idade"));
        colunaEndereco.setCellValueFactory(
                new PropertyValueFactory<>("endereco"));
        
//        tabelaPacientes.setItems(formataDadosPaciente(medicoRepo));
		
	}
	
//	private ObservableList<PacienteModel> formataDadosPaciente(MedicoRepository medicoRepositorio){
////		ArrayList<Paciente> lista = medicoRepositorio.pegarNumPacientes(0));
////		ArrayList<PacienteModel> pacientesComDadosFormatados = new ArrayList<>();
////		
////		for (Paciente p : lista) {
////			pacientesComDadosFormatados.add(new PacienteModel(p.getId(), p.getNome(), p.getDataNascimento(), Integer.toString(p.getEndereco())));
////		}
//		return FXCollections.observableList(pacientesComDadosFormatados);
//	}
}
