package br.com.pi.drot.controllers.Doctor;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import br.com.pi.drot.UI.MainFX;
import br.com.pi.drot.components.SideBarController;
import br.com.pi.drot.components.ListItem.ListItemController;
import br.com.pi.drot.entity.Medico;
import br.com.pi.drot.models.ConsultasMedico;
import br.com.pi.drot.repository.MedicoRepository;
//import br.com.pi.drot.entity.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class MainFXController extends SideBarController implements Initializable{
	public int medicoLogado;
	@FXML
	private Button clickBtn;
	
	@FXML
	public Label numPacientesAtendidosHoje;

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
		System.out.println(medicoRepo.quantidadeConsultasDoDia(medicoLogado, ""));
		numPacientesAtendidosHoje.setText(Integer.toString(medicoRepo.quantidadeConsultasDoDia(medicoLogado, "")));
		
//		ArrayList<Pane> nodes = new ArrayList<Pane>();
//		for (ConsultasMedico consulta : medicoRepo.consultasRealizadas(1)) {
//			Pane node;
//			try {
//				FXMLLoader loader = FXMLLoader.load(getClass().getResource("/views/Doctor/ListItem.fxml"));
////				node.getProperties().put("nomePaciente", consulta.getNomePacienteConsulta());
////				node.getProperties().put("statusPaciente", consulta.getStatusConsulta());
////				System.out.println(node.getProperties().get("nomePaciente"));
//				AnchorPane root = loader.load();
//				ListItemController controller = loader.getController();
//				controller.setData(consulta.getNomePacienteConsulta(), consulta.getStatusConsulta());
//				
////				vitens.getChildren().add(root);
////				
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		};
////		vitens.getChildren().addAll(nodes);
//	}

}
