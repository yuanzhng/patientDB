module com.example.patientdb {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.patientdb to javafx.fxml;
    exports com.example.patientdb;
}