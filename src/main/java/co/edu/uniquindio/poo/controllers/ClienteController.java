package co.edu.uniquindio.poo.controllers;

import co.edu.uniquindio.poo.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ClienteController {

    @FXML
    private TextField nombreClienteField;

    @FXML
    private TextField cedulaField;

    @FXML
    private Button crearClienteButton;

    private Empresa empresa; // Empresa para gestionar clientes

    public ClienteController() {
        // Crear una empresa ficticia para demostración
        empresa = new Empresa("Empresa de Alquiler");
    }

    @FXML
    public void initialize() {
        // Inicializar cualquier comportamiento específico de la vista si es necesario
    }

    // Acción para crear un nuevo cliente
    @FXML
    private void handleCrearCliente(ActionEvent event) {
        String nombreCliente = nombreClienteField.getText().trim();
        String cedulaCliente = cedulaField.getText().trim();

        if (nombreCliente.isEmpty() || cedulaCliente.isEmpty()) {
            mostrarAlerta("Error", "Todos los campos son obligatorios.");
            return;
        }

        Cliente cliente = new Cliente(nombreCliente, cedulaCliente);
        empresa.crearCliente(cliente); // Agregar el cliente a la empresa
        mostrarAlerta("Éxito", "Cliente creado con éxito.");
        limpiarCampos();
    }

    private void limpiarCampos() {
        nombreClienteField.clear();
        cedulaField.clear();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}