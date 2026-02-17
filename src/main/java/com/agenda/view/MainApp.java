package com.agenda.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLOutput;

import static com.agenda.dao.CreateDB.createRelation;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        try {
            createRelation();
        }
        catch (RuntimeException e) {
            e.printStackTrace();
        }

        try {
            URL fxmlLocation = getClass().getResource("/com/agenda/fxml/main-screen.fxml");

            if (fxmlLocation == null) {
                throw new RuntimeException("FXML file don't find. Please check the file path.");
            }

            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage.setTitle("Contact List");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}