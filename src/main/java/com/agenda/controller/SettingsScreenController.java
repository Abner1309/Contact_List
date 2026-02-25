package com.agenda.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsScreenController implements Initializable {
    @FXML
    private Button btnInterface;
    @FXML
    private Button btnAbout;
    @FXML
    private Button btnBack;
    @FXML
    private AnchorPane contentArea;
    @FXML
    private VBox btnGroup;

    private void loadView(String fxmlFileName) {
        try {
            Node node = FXMLLoader.load(getClass().getResource(fxmlFileName));
            contentArea.getChildren().setAll(node);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onClickBack(ActionEvent event) {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void onClickAbout() {
        loadView("/com/agenda/fxml/settings/tab-about-screen.fxml");
    }

    @FXML
    public void onClickInterface() {
        loadView("/com/agenda/fxml/settings/tab-interface-screen.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadView("/com/agenda/fxml/settings/tab-about-screen.fxml");
    }
}
