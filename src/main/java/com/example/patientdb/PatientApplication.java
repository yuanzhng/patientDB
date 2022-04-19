package com.example.patientdb;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PatientApplication extends Application {
    public static Stage stage;
    @Override
    public void start(Stage s) throws IOException {
        this.stage = s;
        FXMLLoader loader = new FXMLLoader(PatientApplication.class.getResource("patientlist-view.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setTitle("PatientDB");
        stage.setScene(scene);
        stage.show();
    }

    public static void switchToEditor(Patient p) throws IOException {
        FXMLLoader loader = new FXMLLoader(PatientApplication.class.getResource("patienteditor-view.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        PatientViewController patientViewController = loader.getController();
        patientViewController.initialize(p);
        stage.setScene(scene);
        stage.show();
    }

    public static void switchToMain() throws IOException {
        FXMLLoader loader = new FXMLLoader(PatientApplication.class.getResource("patientlist-view.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        PatientController patientController = loader.getController();
        patientController.upload();
        patientController.refresh();
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}