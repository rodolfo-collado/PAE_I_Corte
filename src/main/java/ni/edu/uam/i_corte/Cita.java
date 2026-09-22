package ni.edu.uam.i_corte;

public class Cita {
    private String nombre;
    private String telefono;
    private String fecha;

    public Cita(String nombre, String telefono, String fecha) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.fecha = fecha;
    }

    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getFecha() { return fecha; }
}
