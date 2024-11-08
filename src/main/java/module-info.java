module co.edu.uniquindio.poo {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.uniquindio.poo.controllers to javafx.fxml; // Abre el paquete para JavaFX
}