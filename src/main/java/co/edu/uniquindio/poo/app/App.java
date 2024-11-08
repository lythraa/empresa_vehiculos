package co.edu.uniquindio.poo.app;

//import co.edu.uniquindio.poo.controllers.ReservaController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // Cargar el archivo FXML
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/ReservaView.fxml"));
        
        // Establecer el controlador para el archivo FXML
       // fxmlLoader.setController(new ReservaController());

        // Crear la escena y cargarla en el escenario
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        
        // Establecer el título de la ventana
        stage.setTitle("Sistema de Alquiler de Vehículos");
        
        // Establecer la escena en el escenario (ventana)
        stage.setScene(scene);
        
        // Mostrar la ventana
        stage.show();
    }

    public static void main(String[] args) {
        // Lanzar la aplicación JavaFX
        launch(args);
    }
}