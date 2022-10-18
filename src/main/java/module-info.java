module com.example.savingscalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.savingscalculator to javafx.fxml;
    exports com.example.savingscalculator;
}