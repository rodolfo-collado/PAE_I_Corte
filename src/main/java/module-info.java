module ni.edu.uam.i_corte {
    requires javafx.controls;
    requires javafx.fxml;

    opens ni.edu.uam.i_corte to javafx.fxml, javafx.base;
    exports ni.edu.uam.i_corte;
}