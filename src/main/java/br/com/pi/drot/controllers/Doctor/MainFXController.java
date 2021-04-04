package br.com.pi.drot.controllers.Doctor;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.pi.drot.UI.MainFX;
import br.com.pi.drot.components.SideBarController;
import br.com.pi.drot.entity.Medico;
import br.com.pi.drot.repository.MedicoRepository;
//import br.com.pi.drot.entity.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainFXController extends SideBarController implements Initializable{
	public int medicoLogado;
	@FXML
	private Button clickBtn;
	
	@FXML
	private Label numPacientesAtendidosHoje;

	@FXML
	private VBox vitens = null;
	
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
		numPacientesAtendidosHoje.setText(Integer.toString(medicoRepo.quantidadeConsultasDoDia(medicoLogado, loggedUserName)));
		
		Node[] nodes = new Node[10];
		Node[] treatmentItens = new Node[10];
				
		for (int i = 0; i < nodes.length; i++) {
			try {
				nodes[i] = FXMLLoader.load(getClass().getResource("/views/Doctor/ListItem.fxml"));
				vitens.getChildren().add(nodes[i]);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		for (int i = 0; i < nodes.length; i++) {
			try {
				treatmentItens[i] = FXMLLoader.load(getClass().getResource("/views/Doctor/Main/TreatmentItem.fxml"));
				treatmentItems.getChildren().add(treatmentItens[i]);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}
