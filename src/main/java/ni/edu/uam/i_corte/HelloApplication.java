package ni.edu.uam.i_corte;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/ni/edu/uam/i_corte/RegistroView.fxml")
        );
        Scene scene = new Scene(loader.load(), 400, 320);
        stage.setTitle("Registro de Paciente");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(args); }
}