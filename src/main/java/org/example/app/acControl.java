package org.example.app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class acControl implements Initializable {
    @FXML
    private TableView<Ligne> table;
    @FXML
    private TableColumn<Ligne, Integer> id;
    @FXML
    private TableColumn<Ligne, String> nom;
    @FXML
    private TableColumn<Ligne, String> auteur;
    @FXML
    private TableColumn<Ligne, String> type;

    public void delete(MouseEvent mouseEvent) throws IOException {
        Stage stage=new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("supprimer.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        // Implémenter la logique de suppression ici
    }

    public void ajouter(MouseEvent mouseEvent) throws IOException {
        Stage stage=new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ajout.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        // Implémenter la logique d'ajout ici
    }

    public void afficherTout(MouseEvent mouseEvent) {
        charger();
    }

    public void charger() {
        ObservableList<Ligne> ligne = FXCollections.observableArrayList();
        ConnectionDB con = new ConnectionDB();
        String sql = "SELECT * FROM livres";
        try (Connection connection = con.connect();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String auteur = resultSet.getString("auteur");
             // Ajouter la récupération du type
                ligne.add(new Ligne(id, nom, auteur, " type")); // Ajouter le type dans le constructeur
            }

            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            auteur.setCellValueFactory(new PropertyValueFactory<>("auteur"));
            type.setCellValueFactory(new PropertyValueFactory<>("type"));

            table.setItems(ligne);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void quitter(ActionEvent actionEvent) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        charger();
    }
}
