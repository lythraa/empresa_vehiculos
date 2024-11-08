package co.edu.uniquindio.poo.controllers;

import co.edu.uniquindio.poo.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ReservaController {

    @FXML
    private TextField nombreClienteField;

    @FXML
    private TextField cedulaField;

    @FXML
    private TextField diasField;

    @FXML
    private MenuButton vehiculoMenuButton;

    @FXML
    private MenuItem autoMenuItem;

    @FXML
    private MenuItem camionetaMenuItem;

    @FXML
    private MenuItem motoMenuItem;

    @FXML
    private Button realizarAlquilerButton;

    @FXML
    private TextField costoField;

    private Empresa empresa;
    private Cliente clienteSeleccionado;
    private Vehiculo vehiculoSeleccionado;

    public ReservaController() {
        empresa = new Empresa("Empresa de Alquiler");
    }

    @FXML
    public void initialize() {
        autoMenuItem.setOnAction(this::handleSeleccionarAuto);
        camionetaMenuItem.setOnAction(this::handleSeleccionarCamioneta);
        motoMenuItem.setOnAction(this::handleSeleccionarMoto);
    }

    private void handleSeleccionarAuto(ActionEvent event) {
        vehiculoSeleccionado = new Auto("ABC123", "Toyota", "Corolla", (byte) 4);
        vehiculoMenuButton.setText("Auto - " + vehiculoSeleccionado.getMarca() + " " + vehiculoSeleccionado.getModelo());
    }

    private void handleSeleccionarCamioneta(ActionEvent event) {
        vehiculoSeleccionado = new Camioneta("XYZ456", "Ford", "Ranger", 1200.0);
        vehiculoMenuButton.setText("Camioneta - " + vehiculoSeleccionado.getMarca() + " " + vehiculoSeleccionado.getModelo());
    }

    private void handleSeleccionarMoto(ActionEvent event) {
        vehiculoSeleccionado = new Moto("MOTO789", "Honda", "CBR500", TipoCaja.AUTOMATICA);
        vehiculoMenuButton.setText("Moto - " + vehiculoSeleccionado.getMarca() + " " + vehiculoSeleccionado.getModelo());
    }

    @FXML
    private void handleRealizarAlquiler(ActionEvent event) {
        String nombreCliente = nombreClienteField.getText().trim();
        String cedulaCliente = cedulaField.getText().trim();
        String diasPrestamoText = diasField.getText().trim();

        if (nombreCliente.isEmpty() || cedulaCliente.isEmpty() || diasPrestamoText.isEmpty() || vehiculoSeleccionado == null) {
            mostrarAlerta("Error", "Todos los campos son obligatorios y se debe seleccionar un vehículo.");
            return;
        }

        try {
            int diasPrestamo = Integer.parseInt(diasPrestamoText);

            clienteSeleccionado = empresa.buscarClientePorCedula(cedulaCliente);
            if (clienteSeleccionado == null) {
                clienteSeleccionado = new Cliente(nombreCliente, cedulaCliente);
                empresa.crearCliente(clienteSeleccionado);
            }

            Reserva reserva = new Reserva(diasPrestamo, 50.0, clienteSeleccionado, vehiculoSeleccionado);
            empresa.crearReserva(reserva);

            double costo = vehiculoSeleccionado.calcularReserva(reserva);
            costoField.setText(String.format("%.2f", costo));


        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "El campo de días de préstamo debe ser un número válido.");
        }
    }

    

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
