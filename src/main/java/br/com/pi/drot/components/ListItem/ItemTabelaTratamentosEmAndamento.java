package br.com.pi.drot.components.ListItem;

import java.io.IOException;

import br.com.pi.drot.models.TratamentosPaciente;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;

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
