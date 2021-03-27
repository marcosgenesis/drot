package br.com.pi.drot.UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFX extends Application {

	private static Stage stage;
	private static Scene mainScene;
	private static Scene loginScene;
	private static Scene LogadoScene;
	//private static Scene newUserScene;

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			stage = primaryStage;
			primaryStage.setTitle("DROT SYSTEM");

			Parent loaderLogin = FXMLLoader.load(getClass().getResource("/views/Login.fxml"));
			loginScene = new Scene(loaderLogin);

			Parent loaderMain = FXMLLoader.load(getClass().getResource("/views/Main.fxml"));
			mainScene = new Scene(loaderMain);

			Parent loaderLogado = FXMLLoader.load(getClass().getResource("/views/Logado.fxml"));
			LogadoScene = new Scene(loaderLogado);

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

			case "login":
				stage.setScene(loginScene);
				break;

			case "logado":
				stage.setScene(LogadoScene);
				break;
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
