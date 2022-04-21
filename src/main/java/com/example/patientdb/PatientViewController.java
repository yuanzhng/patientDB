package com.example.patientdb;

import java.io.*;
import java.lang.*;
import java.util.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.collections.*;

import static java.lang.Integer.decode;



public class PatientViewController {

    @FXML
    private Button donebtn;

    @FXML
    private TextField fnfld;

    @FXML
    private TextField lnfld;

    @FXML
    private TextField agefld;

    @FXML
    private TextField wbcfld;

    public Patient c;

    @FXML
    public void initialize() {

    }
    public void setPatient(Patient p) {
        this.c = p;
        fnfld.setText(c.getFirstName());
        lnfld.setText(c.getLastName());
        agefld.setText(Integer.toString(c.getAge()));
    }

    public void done() throws IOException {
        c.setFirstName(fnfld.getText());
        c.setLastName(lnfld.getText());
        c.setAge(Integer.parseInt(agefld.getText()));

        try {
            PatientApplication.switchToMain();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}