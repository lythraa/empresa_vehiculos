package co.edu.uniquindio.poo.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class MenuController {

    // Método para manejar la acción de ir a la vista de Cliente
    @FXML
    private void handleClienteView() {
        cargarVista("ClienteView.fxml");
    }

    // Método para manejar la acción de ir a la vista de Vehículo
    @FXML
    private void handleVehiculoView() {
        cargarVista("VehiculoView.fxml");
    }

    // Método para manejar la acción de ir a la vista de Reserva
    @FXML
    private void handleReservaView() {
        cargarVista("ReservaView.fxml");
    }

    // Método común para cargar cualquier vista
    private void cargarVista(String nombreVista) {
        try {
            // Cargar la vista correspondiente
            AnchorPane root = FXMLLoader.load(getClass().getResource("/co/edu/uniquindio/poo/views/" + nombreVista));
            Stage stage = (Stage) root.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
