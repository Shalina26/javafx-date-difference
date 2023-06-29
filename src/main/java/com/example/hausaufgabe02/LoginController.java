package com.example.hausaufgabe02;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    private Stage stage;
    private Parent layout;
    private Scene scene;
    @FXML
    TextField nameTextField;
    public void switchToMainScene(ActionEvent event) throws IOException {
        String username = nameTextField.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainView.fxml"));
        layout = loader.load();

        MainController mainController = loader.getController();
        mainController.displayName(username);
        mainController.setDate();

        String css = getClass().getResource("style.css").toExternalForm();

        scene = new Scene(layout);
        scene.getStylesheets().add(css);

        Node clickedBtn = (Node)event.getSource();

        stage = (Stage)clickedBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}