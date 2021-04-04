package br.com.pi.drot.components.ListItem;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ListItemController implements Initializable {
	@FXML
	private Label nomePaciente;
	@FXML
	private Label statusPaciente;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("resources: "+resources);
	}
	public void setData(String nomePaciente,String statusConsulta) {
        this.nomePaciente.setText(nomePaciente);
        this.nomePaciente.setText(statusConsulta);
    }
}
