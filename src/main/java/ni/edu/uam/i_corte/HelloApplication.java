package ni.edu.uam.i_corte;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 760, 520);
        stage.setTitle("Agenda Salud | Citas médicas");
        stage.setMinWidth(700);
        stage.setMinHeight(480);
        stage.setScene(scene);
        stage.show();
    }
}
