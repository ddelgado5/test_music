package quipux.co.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "listaDeReproducciones", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Cancion> cancion = new ArrayList<>();


    public ListaDeReproducciones(){

    }
    public ListaDeReproducciones(String nombre){
        this.nombre = nombre;
    }


    public ListaDeReproducciones(String nombre, String descripcion, List<Cancion> cancion) {
        super();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cancion = cancion;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //
//    public List<Cancion> getCancion() {
//        return cancion;
//    }
////
//    public void setCancion(List<Cancion> canciones) {
//        this.cancion = canciones;
//    }

    public List<Cancion> getCancion() {
        return cancion;
    }

    public void setCancion(List<Cancion> cancion) {
        this.cancion = cancion;
    }

    @Override
    public String toString() {
        return "ListaDeReproducciones{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\''
                +
                ", cancion=" + cancion +
                '}'
                ;
    }
}
