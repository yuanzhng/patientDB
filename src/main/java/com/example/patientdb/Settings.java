package com.example.patientdb;

import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Settings implements Serializable {
    private int fontSize;
    private static Settings instance;
    private Settings() {
    }
    public static int getFSize(){
        if (Settings.instance == null) {
            try {
                File myObj = new File(System.getProperty("user.home")+"/.settings.ser");
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                } else {
                    try {
                        FileInputStream fileIn = new FileInputStream(System.getProperty("user.home")+"/.settings.ser");
                        ObjectInputStream in = new ObjectInputStream(fileIn);
                        instance = (Settings) in.readObject();
                        in.close();
                        fileIn.close();
                    } catch (IOException i) {
                        i.printStackTrace();
                        Settings.instance = new Settings();
                    } catch (ClassNotFoundException c) {
                        System.out.println("Patient class not found");
                        c.printStackTrace();
                        Settings.instance = new Settings();
                    }
                }
            } catch (IOException e) {
                System.out.println("An error occurred while creating file.");
                e.printStackTrace();
            }
        }
        return instance.fontSize;
    }
    public static Settings getInstance(){
        return instance;
    }
    public static void setFontSize(int fontSize1){

        if (Settings.instance == null) {
            try {
                File myObj = new File(System.getProperty("user.home")+"/.settings.ser");
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                } else {
                    try {
                        FileInputStream fileIn = new FileInputStream(System.getProperty("user.home")+"/.settings.ser");
                        ObjectInputStream in = new ObjectInputStream(fileIn);
                        instance = (Settings) in.readObject();
                        in.close();
                        fileIn.close();
                    } catch (IOException i) {
                        i.printStackTrace();
                        Settings.instance = new Settings();
                    } catch (ClassNotFoundException c) {
                        System.out.println("Patient class not found");
                        c.printStackTrace();
                        Settings.instance = new Settings();
                    }
                }
            } catch (IOException e) {
                System.out.println("An error occurred while creating file.");
                e.printStackTrace();
            }
        }
        instance.fontSize = fontSize1;

    }
}