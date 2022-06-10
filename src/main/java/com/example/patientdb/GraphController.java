package com.example.patientdb;

import javafx.fxml.FXML;
import java.util.*;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class GraphController {
    @FXML
    private BarChart<String, Number> patientchart;
    public void goBack() throws IOException {
        PatientApplication.switchToMain();
    }
    public void start(ArrayList<Patient> patientList) {

        ArrayList<XYChart.Series> entries = new ArrayList();
        for (int i = 0; i < patientList.size(); i++){
            XYChart.Series series = new XYChart.Series();
            series.setName(patientList.get(i).getFirstName() + patientList.get(i).getLastName());
            series.getData().add(new XYChart.Data("patients", patientList.get(i).getAge()));
            entries.add(series);
        }
        for (int i = 0; i < entries.size(); i++){
            patientchart.getData().add(entries.get(i));
        }
    }
    public void initialize(){
        start(PatientController.getPL());
    }
}
