package ni.edu.uam.i_corte;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CitaDAO {
    private static final ObservableList<Cita> citas = FXCollections.observableArrayList();

    public static ObservableList<Cita> getCitas() { return citas; }

    public static void agregar(Cita c) { citas.add(c); }

    public static void eliminar(Cita c) { citas.remove(c); }
}
