package com.agenda.controller.settings;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;

public class InterfaceScreenController implements Initializable {
    @FXML
    private ChoiceBox<String> cbTheme;
    private final String[] themes = {"Light", "Dark"};

    private void applyTheme(Scene scene, String theme) {
        scene.getStylesheets().clear();

        String cssPath = getClass().getResource("/styles/" + theme + ".css").toExternalForm();
        scene.getStylesheets().add(cssPath);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Scene scene = cbTheme.getScene();
        cbTheme.getItems().addAll(themes);
        cbTheme.setValue("Light");

        cbTheme.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            applyTheme(scene, newValue);
        });
    }
}
