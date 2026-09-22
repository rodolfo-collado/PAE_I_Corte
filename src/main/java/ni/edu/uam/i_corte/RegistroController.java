package ni.edu.uam.i_corte;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class RegistroController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtTelefono;
    @FXML private DatePicker dpFecha;
    @FXML private Label lblMensaje;

    @FXML
    private void guardar() {
        String nombre   = txtNombre.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String fecha    = (dpFecha.getValue() != null) ? dpFecha.getValue().toString() : "";

        // VALIDACIONES
        if (nombre.isEmpty()) {
            lblMensaje.setStyle("-fx-text-fill: red;");
            lblMensaje.setText("El nombre es obligatorio");
            return;
        }
        if (!telefono.matches("\\d{8,10}")) {
            lblMensaje.setStyle("-fx-text-fill: red;");
            lblMensaje.setText("Teléfono inválido (8-10 dígitos)");
            return;
        }
        if (fecha.isEmpty()) {
            lblMensaje.setStyle("-fx-text-fill: red;");
            lblMensaje.setText("Debe seleccionar una fecha");
            return;
        }

        CitaDAO.agregar(new Cita(nombre, telefono, fecha));
        lblMensaje.setStyle("-fx-text-fill: green;");
        lblMensaje.setText("Cita registrada");

        txtNombre.clear();
        txtTelefono.clear();
        dpFecha.setValue(null);
    }

    @FXML
    private void verCitas() throws Exception {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/ni/edu/uam/i_corte/ConsultaView.fxml")
        );
        Stage stage = (Stage) txtNombre.getScene().getWindow();
        stage.setScene(new Scene(loader.load(), 500, 400));
        stage.setTitle("Consulta de Citas");
    }
}

