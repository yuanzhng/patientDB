package com.example.patientdb;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SettingsViewController {
    @FXML
    private Button donebtn;
    @FXML
    private TextField settingsfld;
    @FXML
    public void DoneClickedOn() throws IOException {
        if (this.settingsfld != null) {
            int c = Integer.decode(settingsfld.getText());
            Settings.setFontSize(c);
            try {
                FileOutputStream fileOut =
                        new FileOutputStream(System.getProperty("user.home") + "/.settings.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(Settings.getInstance());
                out.close();
                fileOut.close();
                System.out.printf("Serialized data is saved in " + System.getProperty("user.home") + "/.settings.ser\n");
            } catch (IOException i) {
                i.printStackTrace();
            }
        }
        PatientApplication.switchToMain();
    }
    public void updateSettingsFld(){
        settingsfld.setText(Integer.toString(Settings.getFSize()));
    }
}