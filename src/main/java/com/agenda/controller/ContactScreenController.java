package com.agenda.controller;

import com.agenda.dao.ContactDAO;
import com.agenda.model.Contact;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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

    public void setContact(Contact info) {
        idContact = info.getId();
        tfName.setText(info.getName());
        tfPhone.setText(info.getPhone());
        tfEmail.setText(info.getEmail());
    }

    @FXML
    public void onClickBtnDelete(ActionEvent event) {
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
}
