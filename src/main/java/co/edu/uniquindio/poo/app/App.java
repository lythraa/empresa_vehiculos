package co.edu.uniquindio.poo.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Cargar el archivo FXML de la vista del menú
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/MenuView.fxml"));
        AnchorPane root = loader.load();
        
        // Establecer la escena con el contenedor root (MenuView.fxml)
        Scene scene = new Scene(root);
        
        // Título de la ventana
        primaryStage.setTitle("Menú Principal");
        
        // Mostrar la ventana
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
