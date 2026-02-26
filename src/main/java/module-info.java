module com.agenda {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    requires java.sql;
    requires java.prefs;
    requires org.xerial.sqlitejdbc;
    requires org.slf4j;

    opens com.agenda.controller to javafx.fxml;
    opens com.agenda.model to javafx.base;
    opens com.agenda.view to javafx.fxml;

    exports com.agenda.view;
}