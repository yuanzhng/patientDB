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

    public void initialize(Patient p) {

    }
    public void done(Patient p) throws IOException {
        p.setFirstName(fnfld.getText());
        p.setLastName(lnfld.getText());
        p.setAge(Integer.parseInt(agefld.getText()));
        PatientApplication.switchToMain();

    }
}
