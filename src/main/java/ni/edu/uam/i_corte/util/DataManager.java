package ni.edu.uam.i_corte.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ni.edu.uam.i_corte.model.Cita;

public class DataManager {
    private static final ObservableList<Cita> citasList = FXCollections.observableArrayList();

    public static ObservableList<Cita> getCitas() {
        return citasList;
    }
}
