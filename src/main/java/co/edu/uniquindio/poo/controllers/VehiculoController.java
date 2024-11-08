package co.edu.uniquindio.poo.controllers;

import co.edu.uniquindio.poo.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class VehiculoController {

    @FXML
    private TextField placaField;

    @FXML
    private TextField marcaField;

    @FXML
    private TextField modeloField;

    @FXML
    private MenuButton tipoVehiculoMenuButton;

    @FXML
    private MenuItem autoMenuItem;

    @FXML
    private MenuItem camionetaMenuItem;

    @FXML
    private MenuItem motoMenuItem;

    @FXML
    private Button crearVehiculoButton;

    private Empresa empresa;

    private Vehiculo vehiculoSeleccionado;

    public VehiculoController() {
        empresa = new Empresa("Empresa de Alquiler");
    }

    @FXML
    public void initialize() {
        autoMenuItem.setOnAction(this::handleSeleccionarAuto);
        camionetaMenuItem.setOnAction(this::handleSeleccionarCamioneta);
        motoMenuItem.setOnAction(this::handleSeleccionarMoto);
    }

    private void handleSeleccionarAuto(ActionEvent event) {
        tipoVehiculoMenuButton.setText("Auto");
        vehiculoSeleccionado = new Auto("ABC123", "Toyota", "Corolla", (byte) 4);
    }

    private void handleSeleccionarCamioneta(ActionEvent event) {
        tipoVehiculoMenuButton.setText("Camioneta");
        vehiculoSeleccionado = new Camioneta("XYZ456", "Ford", "Ranger", 1200.0);
    }

    private void handleSeleccionarMoto(ActionEvent event) {
        tipoVehiculoMenuButton.setText("Moto");
        vehiculoSeleccionado = new Moto("MOTO789", "Honda", "CBR500", TipoCaja.AUTOMATICA);
    }

    @FXML
    private void handleCrearVehiculo(ActionEvent event) {
        if (placaField.getText().trim().isEmpty() || marcaField.getText().trim().isEmpty() || modeloField.getText().trim().isEmpty()) {
            mostrarAlerta("Error", "Todos los campos son obligatorios.");
            return;
        }

        vehiculoSeleccionado.setPlaca(placaField.getText().trim());
        vehiculoSeleccionado.setMarca(marcaField.getText().trim());
        vehiculoSeleccionado.setModelo(modeloField.getText().trim());

        empresa.crearVehiculo(vehiculoSeleccionado);
        mostrarAlerta("Éxito", "Vehículo creado con éxito.");
        limpiarCampos();
    }

    private void limpiarCampos() {
        placaField.clear();
        marcaField.clear();
        modeloField.clear();
        tipoVehiculoMenuButton.setText("Tipo de Vehículo");
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
