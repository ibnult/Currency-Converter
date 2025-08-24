package com.example.currency_converter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(
                MainApp.class.getResource("converter-view.fxml")
        );
        Scene scene = new Scene(fxmlLoader.load(), 400, 250);
        stage.setTitle("Currency Converter");
        stage.setScene(scene);
        stage.show();
    }

    public static void setScene(Scene scene) {
        primaryStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
