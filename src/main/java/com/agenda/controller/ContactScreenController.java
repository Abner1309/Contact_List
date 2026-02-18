package com.agenda.controller;

import com.agenda.dao.ContactDAO;
import com.agenda.model.Contact;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ContactScreenController {
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
        ContactDAO bdContact = new ContactDAO();
        bdContact.updateContact(idContact, tfName.getText(), tfPhone.getText(), tfEmail.getText());

        Alert alertInformation = new Alert(Alert.AlertType.INFORMATION);
        alertInformation.setTitle("Success!");
        alertInformation.setHeaderText(null);
        alertInformation.setContentText("The contact information has been updated.");
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

        return alert.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK;
    }

    private boolean confirmRemove() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Do you really want to delete the contact?");
        alert.setContentText("The contact will be permanently deleted.");

        return alert.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK;
    }
}
