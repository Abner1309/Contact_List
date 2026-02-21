package com.agenda.controller.settings;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;

import java.net.URL;
import java.util.ResourceBundle;

public class LanguageScreenController implements Initializable {
    @FXML
    private ToggleButton btnEnglish;
    @FXML
    private ToggleButton btnPortuguese;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnEnglish.setSelected(true);
    }
}
