package br.com.pi.drot.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import br.com.pi.drot.components.SideBarController;
import br.com.pi.drot.entity.Paciente;
import br.com.pi.drot.models.PacienteModel;
import br.com.pi.drot.repository.EnderecoRepository;
import br.com.pi.drot.repository.PacienteRepository;
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
		PacienteRepository pacienteRepositorio = new PacienteRepository();

		colunaDataNascimento.setCellValueFactory(
                new PropertyValueFactory<>("dataNascimento"));
        colunaPaciente.setCellValueFactory(
                new PropertyValueFactory<>("nome"));
        colunaIdade.setCellValueFactory(
                new PropertyValueFactory<>("idade"));
        colunaEndereco.setCellValueFactory(
                new PropertyValueFactory<>("endereco"));

        tabelaPacientes.setItems(formataDadosPaciente(pacienteRepositorio));

	}

	private ObservableList<PacienteModel> formataDadosPaciente(PacienteRepository pacienteRepositorio){

		EnderecoRepository enderecoRepositorio = new EnderecoRepository();
		ArrayList<Paciente> lista = pacienteRepositorio.listarPacientesCadastrados();
		ArrayList<PacienteModel> pacientesComDadosFormatados = new ArrayList<>();

		for (Paciente p : lista) {
			pacientesComDadosFormatados.add(
					new PacienteModel(
							p.getId(),
							p.getNome(),
							enderecoRepositorio.pegarInformacoesEnderecoPorID(p.getEndereco()),
							p.getDataNascimento()
							));
		}
		return FXCollections.observableList(pacientesComDadosFormatados);
	}
}
