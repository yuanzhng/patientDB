package com.example.patientdb;

import java.io.*;
import java.lang.*;
import java.util.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.collections.*;
import javafx.scene.text.Font;

import static java.lang.Integer.decode;

public class PatientController {
    @FXML
    private Button graphbtn;
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

    @FXML
    private Label title;

    public static ArrayList patientList = new ArrayList<Patient>();

    public static ArrayList getPL() {
        return patientList;
    }

    public static void setPL(ArrayList a) {
        patientList = a;
    }
    public void initialize() {
        setTitleFontSize();
        ArrayList n = new ArrayList();
        try {
            File myObj = new File(System.getProperty("user.home")+"/.data.ser");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                try {
                    FileInputStream fileIn = new FileInputStream(System.getProperty("user.home")+"/.data.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    n = (ArrayList) in.readObject();
                    in.close();
                    fileIn.close();
                } catch (IOException i) {
                    i.printStackTrace();
                    return;
                } catch (ClassNotFoundException c) {
                    System.out.println("Patient class not found");
                    c.printStackTrace();
                    return;
                }
                setPL(n);
                lastclm.setCellValueFactory(new PropertyValueFactory<>("lastName"));
                firstclm.setCellValueFactory(new PropertyValueFactory<>("firstName"));
                ageclm.setCellValueFactory(new PropertyValueFactory<>("age"));
                cellclm.setCellValueFactory(new PropertyValueFactory<>("whiteCellCount"));
                table.setItems(FXCollections.observableList(patientList));
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating file.");
            e.printStackTrace();
        }
    }

    @FXML
    public void setTitleFontSize() {
        title.setFont(new Font(Settings.getFSize()));
    }

    @FXML
    public void gotoEdit() throws IOException {
        Patient p = (Patient) table.getSelectionModel().getSelectedItem();
        PatientApplication.switchToEditor(p);
    }
    @FXML
    public void gotoSettings() throws IOException {
        PatientApplication.switchToSettings();
    }

    @FXML
    public void gotoGraph() throws IOException {
        PatientApplication.switchToGraph();

    }

    @FXML
    public void refresh() {
        lastclm.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        firstclm.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        ageclm.setCellValueFactory(new PropertyValueFactory<>("age"));
        cellclm.setCellValueFactory(new PropertyValueFactory<>("whiteCellCount"));
        table.setItems(FXCollections.observableList(patientList));
        table.refresh();
    }

    @FXML
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

        Optional<String> f = fin.showAndWait();
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

        upload();
        refresh();
    }
    public void upload() {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream(System.getProperty("user.home")+"/.data.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(patientList);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in " + System.getProperty("user.home") + "/.data.ser\n");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

}