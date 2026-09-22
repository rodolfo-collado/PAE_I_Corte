package ni.edu.uam.i_corte.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import ni.edu.uam.i_corte.Launcher;
import ni.edu.uam.i_corte.model.Cita;
import ni.edu.uam.i_corte.util.DataManager;

import java.time.LocalDate;

public class RegistroController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtTelefono;
    @FXML private DatePicker dpFecha;

    @FXML
    private void guardarCita() {
        String nombre = txtNombre.getText();
        String telefono = txtTelefono.getText();
        LocalDate fecha = dpFecha.getValue();

        // 1. Validación de datos principales
        if (nombre == null || nombre.trim().isEmpty() ||
                telefono == null || telefono.trim().isEmpty() ||
                fecha == null) {
            mostrarAlerta("Error de Validación", "Todos los campos son obligatorios.");
            return;
        }

        if (!telefono.matches("\\d{8,}")) {
            mostrarAlerta("Error de Validación", "El teléfono debe contener al menos 8 dígitos numéricos.");
            return;
        }

        // 2. Guardar datos
        DataManager.getCitas().add(new Cita(nombre, telefono, fecha));

        // 3. Limpiar formulario
        txtNombre.clear();
        txtTelefono.clear();
        dpFecha.setValue(null);

        mostrarAlerta("Éxito", "Cita registrada correctamente.");
    }

    @FXML
    private void irAConsultas() {
        Launcher.setRoot("consulta");
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}