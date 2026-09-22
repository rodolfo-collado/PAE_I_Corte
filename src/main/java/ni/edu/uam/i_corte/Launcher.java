package ni.edu.uam.i_corte;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Launcher extends Application {
    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        primaryStage.setTitle("Gestión de Citas - Clínica");
        setRoot("registro");
        primaryStage.show();
    }

    // Método estático para navegar entre formularios
    public static void setRoot(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(Launcher.class.getResource(fxml + ".fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 600, 400);

            // Cargar estilos
            String css = Launcher.class.getResource("styles.css").toExternalForm();
            scene.getStylesheets().add(css);

            primaryStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}