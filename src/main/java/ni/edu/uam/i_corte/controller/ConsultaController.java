package ni.edu.uam.i_corte;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ni.edu.uam.i_corte.model.Cita;
import ni.edu.uam.i_corte.util.DataManager;

import java.time.LocalDate;

public class ConsultaController {

    @FXML private TableView<Cita> tablaCitas;
    @FXML private TableColumn<Cita, String> colNombre;
    @FXML private TableColumn<Cita, String> colTelefono;
    @FXML private TableColumn<Cita, LocalDate> colFecha;

    @FXML
    public void initialize() {
        // Configurar columnas
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));

        // Llenar tabla con los datos
        tablaCitas.setItems(DataManager.getCitas());
    }

    @FXML
    private void volverAlRegistro() {
        Launcher.setRoot("registro");
    }
}
