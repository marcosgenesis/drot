package br.com.pi.drot.controllers.Doctor;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.pi.drot.UI.MainFX;
import br.com.pi.drot.components.SideBarController;
//import br.com.pi.drot.entity.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainFXController extends SideBarController implements Initializable{

	@FXML
	private Button clickBtn;

	@FXML
	private VBox vitens = null;
	
	@FXML
	private HBox alertItems = null;
	
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
		Node[] nodes = new Node[100];
		Node[] alertItens = new Node[10];
				
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
				alertItens[i] = FXMLLoader.load(getClass().getResource("/views/Doctor/AlertListItem.fxml"));
				alertItems.getChildren().add(alertItens[i]);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}
