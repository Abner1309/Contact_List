package com.agenda.controller.settings;

import com.agenda.controller.ThemeManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;

import java.net.URL;
import java.util.ResourceBundle;

public class InterfaceScreenController implements Initializable {
    @FXML
    private ToggleButton tbLight;
    @FXML
    private ToggleButton tbDark;
    private final String[] themes = {"Light", "Dark"};

    @FXML
    public void onClickBtnLight() {
        tbLight.setSelected(true);
        tbDark.setSelected(false);
        ThemeManager.saveTheme("Light");
        ThemeManager.applyThemeInAllScenes();
    }

    @FXML
    public void onClickBtnDark() {
        tbLight.setSelected(false);
        tbDark.setSelected(true);
        ThemeManager.saveTheme("Dark");
        ThemeManager.applyThemeInAllScenes();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tbLight.setSelected(true);
    }
}
