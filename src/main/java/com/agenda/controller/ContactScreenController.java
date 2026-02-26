package com.agenda.controller;

import com.agenda.dao.ContactDAO;
import com.agenda.model.Contact;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ContactScreenController implements Initializable {
    private int idContact;
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfPhone;
    @FXML
    private TextField tfEmail;

    @FXML
    private Button btnBack;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnSave;

    public void setContact(Contact info) {
        idContact = info.getId();
        tfName.setText(info.getName());
        tfPhone.setText(info.getPhone());
        tfEmail.setText(info.getEmail());
        bindingBtnSave();
    }

    public void bindingBtnSave() {
        String originalName = tfName.getText();
        String originalPhone = tfPhone.getText();
        String originalEmail = tfEmail.getText();

        btnSave.disableProperty().bind(
                tfName.textProperty().isEqualTo(originalName)
                        .and(tfPhone.textProperty().isEqualTo(originalPhone))
                        .and(tfEmail.textProperty().isEqualTo(originalEmail))
        );
    }

    @FXML
    public void onClickBtnSave(ActionEvent event) {
        String strName = tfName.getText();
        String strPhone = tfEmail.getText();
        String strEmail = tfEmail.getText();

        if (strName.length() > 100 || strPhone.length() > 50 || strEmail.length() > 100) {
            Alert alertError = new Alert(Alert.AlertType.ERROR);
            alertError.setHeaderText("Character Limit Exceeded.!");
            alertError.setContentText("The name and email address must have a maximum of 100 characters, and the phone number, 50 characters.");
            DialogPane dialogPane = alertError.getDialogPane();
            dialogPane.getStylesheets().clear();
            dialogPane.getStylesheets().add(getClass().getResource(ThemeManager.getThemePath()).toExternalForm());
            alertError.showAndWait();
            return;
        }

        ContactDAO bdContact = new ContactDAO();
        bdContact.updateContact(idContact, tfName.getText(), tfPhone.getText(), tfEmail.getText());

        Alert alertInformation = new Alert(Alert.AlertType.INFORMATION);
        alertInformation.setTitle("Success!");
        alertInformation.setHeaderText(null);
        alertInformation.setContentText("The contact information has been updated.");
        DialogPane dialogPane = alertInformation.getDialogPane();
        dialogPane.getStylesheets().clear();
        dialogPane.getStylesheets().add(getClass().getResource(ThemeManager.getThemePath()).toExternalForm());
        alertInformation.showAndWait();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    public void onClickBtnDelete(ActionEvent event) {
        if (!confirmRemove()) {
            return;
        }

        ContactDAO bdContact = new ContactDAO();
        bdContact.removeContact(idContact);

        Alert alertInformation = new Alert(Alert.AlertType.INFORMATION);
        alertInformation.setTitle("Success!");
        alertInformation.setHeaderText(null);
        alertInformation.setContentText("The contact has been deleted.");
        DialogPane dialogPane = alertInformation.getDialogPane();
        dialogPane.getStylesheets().clear();
        dialogPane.getStylesheets().add(getClass().getResource(ThemeManager.getThemePath()).toExternalForm());
        alertInformation.showAndWait();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    public void onClickBack(ActionEvent event) {
        if (confirmExit()) {
            Stage stage = (Stage) btnBack.getScene().getWindow();
            stage.close();
        }
    }

    private boolean confirmExit() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Do you really want to leave?");
        alert.setContentText("The changes will be lost.");
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().clear();
        dialogPane.getStylesheets().add(getClass().getResource(ThemeManager.getThemePath()).toExternalForm());

        return alert.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK;
    }

    private boolean confirmRemove() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Do you really want to delete the contact?");
        alert.setContentText("The contact will be permanently deleted.");
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().clear();
        dialogPane.getStylesheets().add(getClass().getResource(ThemeManager.getThemePath()).toExternalForm());

        return alert.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        javafx.application.Platform.runLater(() -> {
            Stage stage = (Stage) btnBack.getScene().getWindow();

            stage.setOnCloseRequest(event -> {
                if (!confirmExit()) {
                    event.consume();
                }
            });
        });
    }
}
