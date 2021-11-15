package quipux.co.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "listaDeReproducciones")
public class ListaDeReproducciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_listaDeReproducciones", nullable = false, unique = true)
    private Long id;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "descripcion", length = 150)
    private String descripcion;

//    @OneToMany(mappedBy = "cancion", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JsonManagedReference
//    private List<Cancion> cancion = new ArrayList<>();

//    public ListaDeReproducciones(String nombre, String descripcion, List<Cancion> cancion) {

    public ListaDeReproducciones(){

    }
    public ListaDeReproducciones(String nombre){
        this.nombre = nombre;
    }

    public ListaDeReproducciones(String nombre, String descripcion) {
        super();
        this.nombre = nombre;
        this.descripcion = descripcion;
//        this.cancion = cancion;
    }

    public ListaDeReproducciones(Long id){
        this.id = id;
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
//
//    public List<Cancion> getCancion() {
//        return cancion;
//    }
//
//    public void setCancion(List<Cancion> cancion) {
//        this.cancion = cancion;
//    }

    @Override
    public String toString() {
        return "ListaDeReproducciones{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\''
//                +
//                ", cancion=" + cancion +
//                '}'
                ;
    }
}
