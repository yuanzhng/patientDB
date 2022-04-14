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
        FXMLLoader fxmlLoader = new FXMLLoader(PatientApplication.class.getResource("patientlist-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("PatientDB");
        stage.setScene(scene);
        stage.show();
    }
    public void switchToEditor() throws IOException {
        FXMLLoader loader = new FXMLLoader(PatientApplication.class.getResource("patienteditor-view.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        PatientController patientController = loader.getController();
        stage.setScene(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}