package br.com.pi.drot.UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFX extends Application {

	private static Stage stage;
	private static Scene mainScene;
	//private static Scene newUserScene;

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			stage = primaryStage;
			primaryStage.setTitle("DROT SYSTEM");

			Parent loaderMain = FXMLLoader.load(getClass().getResource("/views/Main.fxml"));
			mainScene = new Scene(loaderMain);

			//Parent loaderNewUser = FXMLLoader.load(getClass().getResource("/views/NovoUsuarioCeneFX.fxml"));
			//newUserScene = new Scene(loaderNewUser);

			primaryStage.setResizable(false);
			primaryStage.setScene(mainScene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void chanceWindow (String windowOption) {
		switch (windowOption) {
			case "main":
				stage.setScene(mainScene);
				break;
			//case "newuser":
				//stage.setScene(newUserScene);
				//break;
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
