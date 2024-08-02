package org.example.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Ajout {
    @FXML
    private TextField idch,nomch,auteurch;

    @FXML
    private Button addbtn;
    public void ajouter(ActionEvent actionEvent) throws SQLException {
        Data data=new Data();
        data.inserer(nomch.getText(),auteurch.getText());
        Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();

    }
}
