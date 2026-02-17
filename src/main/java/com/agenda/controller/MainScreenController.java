package com.agenda.controller;

import com.agenda.dao.ContactDAO;
import com.agenda.model.Contact;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {
    @FXML
    private Button btnAddContact;
    @FXML
    private Button btnSettings;
    @FXML
    private TextField txtSearch;
    @FXML
    private ListView<Contact> lvContacts;
    private ObservableList<Contact> obsContacts = FXCollections.observableArrayList();
    private FilteredList<Contact> filteredContacts;
    private final ContactDAO contactDAO = new ContactDAO();

    @FXML
    public void onClickAddContact(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/agenda/fxml/add-screen.fxml"));
            Parent root = loader.load();
            Scene novaCena = new Scene(root);
            Stage stageAdd = new Stage();
            stageAdd.setTitle("Add Contact");
            stageAdd.setScene(novaCena);
            stageAdd.setResizable(false);
            stageAdd.showAndWait();
            loadContacts();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void onClickEditContact(Contact contact) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/agenda/fxml/contact-screen.fxml"));
            Parent root = loader.load();

            ContactScreenController controller = loader.getController();
            controller.setContact(contact);

            Stage stage = new Stage();
            stage.setScene(new Scene (root));
            stage.setTitle("Contact Details");
            stage.setResizable(false);
            stage.showAndWait();
            loadContacts();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Contact> list = contactDAO.listAllContacts();
        obsContacts.addAll(list);
        filteredContacts = new FilteredList<>(obsContacts, p -> true);
        lvContacts.setItems(filteredContacts);

        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredContacts.setPredicate(contact -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                return contact.getName().toLowerCase().contains(lowerCaseFilter);
            });
        });

        lvContacts.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2 && lvContacts.getSelectionModel().getSelectedItem() != null) {
                onClickEditContact(lvContacts.getSelectionModel().getSelectedItem());
            }
        });
    }

    public void loadContacts() {
        List<Contact> list = contactDAO.listAllContacts();
        obsContacts.setAll(list);
    }
}
