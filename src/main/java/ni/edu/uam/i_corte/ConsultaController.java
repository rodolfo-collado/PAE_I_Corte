package ni.edu.uam.i_corte;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ConsultaController {

    @FXML private TableView<Cita> tablaCitas;
    @FXML private TableColumn<Cita, String> colNombre;
    @FXML private TableColumn<Cita, String> colTelefono;
    @FXML private TableColumn<Cita, String> colFecha;

    @FXML
    public void initialize() {
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        tablaCitas.setItems(CitaDAO.getCitas());
    }

    @FXML
    private void volver() throws Exception {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/ni/edu/uam/i_corte/RegistroView.fxml")
        );
        Stage stage = (Stage) tablaCitas.getScene().getWindow();
        stage.setScene(new Scene(loader.load(), 400, 320));
        stage.setTitle("Registro de Paciente");
    }

    @FXML
    private void eliminar() {
        Cita seleccionada = tablaCitas.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            CitaDAO.eliminar(seleccionada);
        }
    }
}