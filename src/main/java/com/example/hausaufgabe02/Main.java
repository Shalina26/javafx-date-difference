package com.example.hausaufgabe02;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        Parent layout = FXMLLoader.load(getClass().getResource("LoginView.fxml"));

        String css = getClass().getResource("style.css").toExternalForm();

        Scene scene = new Scene(layout);
        scene.getStylesheets().add(css);

        stage.setTitle("Differenzrechner");
        stage.setScene(scene);
        stage.show();
    }
}