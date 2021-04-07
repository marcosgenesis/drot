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
	private static Scene PatientsScene;
	private static Scene DoctorsScene;
	private static Scene NewPatientInQueue;
	private static Scene NewPatient;
	private static Scene NewDoctor;
	private static Scene MainDoctorScene;
	private static Scene DoctorPatients;
	private static Scene DoctorTreatments;

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			stage = primaryStage;
			primaryStage.setTitle("DROT SYSTEM");

			Parent loaderLogin = FXMLLoader.load(getClass().getResource("/views/Login.fxml"));
			loginScene = new Scene(loaderLogin);

			Parent loaderMain = FXMLLoader.load(getClass().getResource("/views/Secretary/Main.fxml"));
			mainScene = new Scene(loaderMain);

			Parent patientsScene = FXMLLoader.load(getClass().getResource("/views/Secretary/Patients.fxml"));
			PatientsScene = new Scene(patientsScene);

			Parent doctorsScene = FXMLLoader.load(getClass().getResource("/views/Secretary/Doctors.fxml"));
			DoctorsScene = new Scene(doctorsScene);

			Parent newPacientInQueue = FXMLLoader.load(getClass().getResource("/views/Secretary/newPacientInQueue.fxml"));
			NewPatientInQueue = new Scene(newPacientInQueue);

			Parent newPatient = FXMLLoader.load(getClass().getResource("/views/Secretary/NewPatient.fxml"));
			NewPatient = new Scene(newPatient);
			
			Parent mainDoctor = FXMLLoader.load(getClass().getResource("/views/Doctor/Main/Main.fxml"));
			MainDoctorScene = new Scene(mainDoctor);

			Parent newDoctor = FXMLLoader.load(getClass().getResource("/views/Secretary/NewDoctor.fxml"));
			NewDoctor = new Scene(newDoctor);
			
			Parent doctorPatients = FXMLLoader.load(getClass().getResource("/views/Doctor/Patients/Patients.fxml"));
			DoctorPatients = new Scene(doctorPatients);
			
			Parent doctorTreatments= FXMLLoader.load(getClass().getResource("/views/Doctor/Treatments/Treatments.fxml"));
			DoctorTreatments = new Scene(doctorTreatments);

			primaryStage.setResizable(false);
			primaryStage.setScene(loginScene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void chanceWindow (String windowOption) {
		System.out.println(windowOption);
		switch (windowOption) {
			case "main":
				stage.setScene(mainScene);
				break;

			case "login":
				stage.setScene(loginScene);
				break;

			case "logado":
				stage.setScene(mainScene);
				break;

			case "patientsScene":
				stage.setScene(PatientsScene);
				break;

			case "doctorsScene":
				stage.setScene(DoctorsScene);
				break;

			case "newPacientInQueue":
				stage.setScene(NewPatientInQueue);
				break;

			case "newPatient":
				stage.setScene(NewPatient);
				break;

			case "newDoctor":
				stage.setScene(NewDoctor);
				break;
				
			case "mainDoctorScene":
				stage.setScene(MainDoctorScene);
				break;
				
			case "doctorPatientsScene":
				stage.setScene(DoctorPatients);
				break;
			
			case "doctorTreatmentsScene":
				stage.setScene(DoctorTreatments);
				break;
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
