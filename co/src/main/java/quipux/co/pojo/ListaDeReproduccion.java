package quipux.co.pojo;

public class ListaDeReproduccion {

    private String nombre;
    private String descripcion;
    private Canciones canciones;

    public ListaDeReproduccion(String nombre, String descripcion, Canciones canciones) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.canciones = canciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Canciones getCanciones() {
        return canciones;
    }

    public void setCanciones(Canciones canciones) {
        this.canciones = canciones;
    }
}
