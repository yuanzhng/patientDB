package com.example.patientdb;

import java.io.*;
import java.lang.*;
import java.util.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.collections.*;
import java.nio.file.*;

import static java.lang.Integer.decode;

public class PatientController {

    @FXML
    private Button newbtn;

    @FXML
    private TableColumn lastclm;

    @FXML
    private TableColumn firstclm;

    @FXML
    private TableColumn ageclm;

    @FXML
    private TableColumn cellclm;

    @FXML
    private TableView table;

    List patientList = new ArrayList();

    public void initialize() {
        Path p = new Path("t.ser");
        if (!exists())
        refresh();
    }

    public void refresh() {
        lastclm.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        firstclm.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        ageclm.setCellValueFactory(new PropertyValueFactory<>("age"));
        cellclm.setCellValueFactory(new PropertyValueFactory<>("whiteCellCount"));
        table.setItems(FXCollections.observableList(patientList));
    }

    public void addPatient() {
        TextInputDialog lin = new TextInputDialog("");
        lin.setTitle("Add patient");
        lin.setHeaderText("Please enter patient's information.");
        lin.setContentText("Last name:");

        Optional<String> l = lin.showAndWait();
        String ls = l.get();

        TextInputDialog fin = new TextInputDialog("");
        fin.setTitle("Add patient");
        fin.setHeaderText("Please enter patient's information.");
        fin.setContentText("First name:");

        Optional<String> f = lin.showAndWait();
        String fs = f.get();

        TextInputDialog ain = new TextInputDialog("");
        ain.setTitle("Add patient");
        ain.setHeaderText("Please enter patient's information.");
        ain.setContentText("Age:");

        Optional<String> a = ain.showAndWait();
        int as = decode(a.get());

        TextInputDialog bin = new TextInputDialog("");
        bin.setTitle("Add patient");
        bin.setHeaderText("Please enter patient's information.");
        bin.setContentText("White blood cell count:");

        Optional<String> b = bin.showAndWait();
        int bs = decode(b.get());

        Patient n = new Patient(fs, ls, as, bs);
        patientList.add(n);

        refresh();
    }
}