package ni.edu.uam.i_corte.model;

import java.time.LocalDate;

public class Cita {
    private String nombre;
    private String telefono;
    private LocalDate fecha;

    public Cita(String nombre, String telefono, LocalDate fecha) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.fecha = fecha;
    }

    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public LocalDate getFecha() { return fecha; }
}