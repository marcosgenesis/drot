package br.com.pi.drot.components.ListItem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.com.pi.drot.models.ConsultasMedico;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class ItemTabelaConsultaJaAtendida extends ListCell<ConsultasMedico>{
	@FXML
	private Label nomePaciente;
	
	@FXML
	private Label statusPaciente;
	
	@FXML
	private Label iniciaisNome;
	
	@FXML
	private AnchorPane content;
	
	@FXML
	private ImageView iconeStatus;
	
	private FXMLLoader mLLoader;

    @Override
    protected void updateItem(ConsultasMedico consulta, boolean empty) {
        super.updateItem(consulta, empty);

        if(empty || consulta == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/views/Doctor/ListItem.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            nomePaciente.setText(String.valueOf(consulta.getNomePacienteConsulta()));
            statusPaciente.setText(consulta.getStatusConsulta());
            String[] nomesSeparadosPorEspacos = nomePaciente.getText().split(" ");
      
            String iniciais = String.valueOf(nomesSeparadosPorEspacos[0].charAt(0));
            iniciais += String.valueOf(nomesSeparadosPorEspacos[1].charAt(0));
            iniciaisNome.setText(iniciais.toUpperCase());
            switch (this.statusPaciente.getText()) {
			case "Internação":
				{
					File file = new File("src/main/resources/images/icone-internacao.png");
			        Image image = new Image(file.toURI().toString());
					iconeStatus.setImage(image);
					break;
				}
			case "Medicação":
				{
					File file = new File("src/main/resources/images/Icone-Pills-Azul.png");
			        Image image = new Image(file.toURI().toString());
					iconeStatus.setImage(image);
					break;
				}

			default:
				{
					File file = new File("src/main/resources/images/Liberado.png");
			        Image image = new Image(file.toURI().toString());
					iconeStatus.setImage(image);
					break;
				}
			}

            setText(null);
            setGraphic(content);
        }

    }


}
