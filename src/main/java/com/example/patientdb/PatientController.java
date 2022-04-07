package com.example.patientdb;

import java.util.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.collections.*;

public class PatientController {

    @FXML
    private Button newbtn;

    @FXML
    private TableColumn lastclm;

    @FXML
    private TableColumn firstclm;

    @FXML
    private TableColumn ageclm;

    public void initialize() {
        List patientList = new ArrayList();
        patientList.add(new Patient("Alison", "Apple", 49, 5000));
        patientList.add(new Patient("Bill", "Baker", 18, 1001));
        patientList.add(new Patient("Curt", "Cartwright", 37, 10500));
        patientList.add(new Patient("Dilan", "Dolan", 76, 789));

        lastclm.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        firstclm.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        ageclm.setCellValueFactory(new PropertyValueFactory<>("age"));
        //table.setItems(FXCollections.observableList(patientList));
    }
}