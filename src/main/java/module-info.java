module com.example.hausaufgabe02 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hausaufgabe02 to javafx.fxml;
    exports com.example.hausaufgabe02;
}