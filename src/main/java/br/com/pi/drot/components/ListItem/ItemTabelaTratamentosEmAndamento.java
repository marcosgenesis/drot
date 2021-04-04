package br.com.pi.drot.components.ListItem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.com.pi.drot.entity.TratamentoPaciente;
import br.com.pi.drot.models.ConsultasMedico;
import br.com.pi.drot.models.TratamentosPaciente;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class ItemTabelaTratamentosEmAndamento extends ListCell<TratamentosPaciente>{
	@FXML
	private Label nomePaciente;
	
	@FXML
	private Label progressoAndamento;
	
	@FXML
	private ProgressBar progresso;
	
	@FXML
	private Label iniciaisNome;
	
	@FXML
	private AnchorPane content;
	
	@FXML
	private Button verHistorico;
	
	private FXMLLoader mLLoader;

    @Override
    protected void updateItem(TratamentosPaciente tratamento, boolean empty) {
        super.updateItem(tratamento, empty);

        if(empty || tratamento == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/views/Doctor/Main/TreatmentItem.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            nomePaciente.setText(String.valueOf(tratamento.getNomePaciente()));
            progressoAndamento.setText(tratamento.getPorcentagemTratamentoString());
            System.out.println("porcentagem em double" + tratamento.getPorcentagemDouble());
            progresso.setProgress(tratamento.getPorcentagemDouble()/100);
            
            
            String[] nomesSeparadosPorEspacos = nomePaciente.getText().split(" ");
      
            String iniciais = String.valueOf(nomesSeparadosPorEspacos[0].charAt(0));
            iniciais += String.valueOf(nomesSeparadosPorEspacos[1].charAt(0));
            iniciaisNome.setText(iniciais.toUpperCase());

            setText(null);
            setGraphic(content);
        }

    }


}
