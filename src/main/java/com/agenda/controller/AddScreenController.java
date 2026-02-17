package com.agenda.controller;

import com.agenda.dao.ContactDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class AddScreenController implements Initializable {
    @FXML
    private Button btnCancel;
    @FXML
    private Button btnSend;
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfPhone;
    @FXML
    private TextField tfEmail;
    private final ContactDAO contactDAO = new ContactDAO();

    private boolean confirmExit() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Do you really want to leave?");
        alert.setContentText("The changes will be lost.");

        return alert.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK;
    }

    public void onClickCancel(ActionEvent event) {
        if (confirmExit()) {
            Stage stage = (Stage) btnCancel.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    public void onClickSend(ActionEvent event) {
        String strName = tfName.getText();
        String strPhone = tfPhone.getText();
        String strEmail = tfEmail.getText();

        if (tfName.getText().isEmpty() || tfPhone.getText().isEmpty()) {
            Alert alertError = new Alert(Alert.AlertType.ERROR);
            alertError.setHeaderText("Mandatory Fields!");
            alertError.setContentText("Please, fill the Name and Phone.");
            alertError.showAndWait();
            return;
        }

        contactDAO.insertContact(strName, strPhone, strEmail);

        Alert alertInformation = new Alert(Alert.AlertType.INFORMATION);
        alertInformation.setTitle("Success!");
        alertInformation.setHeaderText(null);
        alertInformation.setContentText("Contact saved successfully.");
        alertInformation.showAndWait();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        javafx.application.Platform.runLater(() -> {
            Stage stage = (Stage) btnCancel.getScene().getWindow();

            stage.setOnCloseRequest(event -> {
                if (!confirmExit()) {
                    event.consume();
                }
            });
        });
    }
}
