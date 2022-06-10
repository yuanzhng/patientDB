package com.example.patientdb;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PatientApplication extends Application {
    public static Stage stage;
    public static Scene patientScene;
    public static Scene tableScene;
    public static Scene settingsScene;
    public static Scene graphScene;
    public static FXMLLoader mainLoader;
    public static FXMLLoader editLoader;
    public static FXMLLoader settingsLoader;
    public static FXMLLoader graphLoader;

    @Override
    public void start(Stage s) throws IOException {
        this.stage = s;
        mainLoader = new FXMLLoader(PatientApplication.class.getResource("patientlist-view.fxml"));
        Parent root = mainLoader.load();
        patientScene = new Scene(root);
        stage.setScene(patientScene);
        stage.show();
    }

    public static void switchToEditor(Patient p) throws IOException {
        editLoader = new FXMLLoader(PatientApplication.class.getResource("patienteditor-view.fxml"));
        Parent root = editLoader.load();
        tableScene = new Scene(root);
        PatientViewController patientViewController = editLoader.getController();
        patientViewController.setPatient(p);
        stage.setScene(tableScene);
        stage.show();
    }

    public static void switchToSettings() throws IOException {
        settingsLoader = new FXMLLoader(PatientApplication.class.getResource("settings-view.fxml"));
        Parent root = settingsLoader.load();
        settingsScene = new Scene(root);
        stage.setScene(settingsScene);
        stage.show();
    }


    public static void switchToMain() throws IOException {
        PatientController patientController = mainLoader.getController();
        patientController.upload();
        patientController.refresh();
        patientController.setTitleFontSize();
        stage.setScene(patientScene);
        stage.show();
    }

    public static void switchToGraph() throws IOException {
        graphLoader = new FXMLLoader(PatientApplication.class.getResource("graph-view.fxml"));
        Parent root = graphLoader.load();
        graphScene = new Scene(root);
        stage.setScene(graphScene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}