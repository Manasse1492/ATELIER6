package org.example.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Supprimer {
    @FXML
    private TextField id;
    public void supprimer(ActionEvent actionEvent) throws SQLException {
        Data data=new Data();
        data.supprimer(Integer.parseInt(id.getText()));
        Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
