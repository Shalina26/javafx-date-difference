package com.example.hausaufgabe02;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class MainController {

    @FXML
    Label welcomeLabel;
    @FXML
    Label dateLabel;
    @FXML
    Label resultLabel;
    @FXML
    Label diffLabel;
    @FXML
    Label errLabel;
    @FXML
    DatePicker datePicker;

    LocalDate currentDate;

    public void displayName(String username){
        welcomeLabel.setText("Willkommen " + username + ",");
    }

    public void setDate() {
        currentDate = LocalDate.now();
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        dateLabel.setText(currentDate.format(myFormat));
    }

    public void calcDateDifference(ActionEvent event) {
        Period period;

        try{
            LocalDate myDate = datePicker.getValue();
            period = Period.between(currentDate, myDate);

            String yearDiff;
            String monthDiff;
            String dayDiff;

            if (Math.abs(period.getYears()) == 1){
                yearDiff = "1 Jahr, ";
            } else if (Math.abs(period.getYears()) == 0) {
                yearDiff = "";
            } else {
                yearDiff = Math.abs(period.getYears()) + " Jahre, ";
            }

            if (Math.abs(period.getMonths()) == 1){
                monthDiff = "1 Monat, ";
            } else if (Math.abs(period.getMonths()) == 0) {
                monthDiff = "";
            } else {
                monthDiff = Math.abs(period.getMonths()) + " Monate, ";
            }

            if (Math.abs(period.getDays()) == 1){
                dayDiff = "1 Tag";
            } else if (Math.abs(period.getDays()) == 0) {
                dayDiff = "";
            } else {
                dayDiff = Math.abs(period.getDays()) + " Tage";
            }
            errLabel.setText("");
            diffLabel.setText("Die Zeitdifferenz beträgt:");
            resultLabel.setText(yearDiff + monthDiff + dayDiff);
        }
        catch (Exception exception){
            errLabel.setText("Das eingegebene Datum entspricht nicht dem richtigen Format (dd/mm/yyyy)");
        }







    }
}
