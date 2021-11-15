package quipux.co.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Cancion")
public class Cancion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cancion", nullable = false, unique = true)
    private Long id;

    @Column(name = "titulo", length = 150)
    private String titulo;

    @Column(name = "artista", length = 150)
    private String artista;

    @Column(name = "album", length = 150)
    private String album;

    @Column(name = "anno", length = 150)
    private String anno;

    @ManyToOne
    private ListaDeReproducciones listaDeReproducciones;

    public Cancion(){

    }
//    public Cancion(String titulo, String artista, String album, String anno, ListaDeReproducciones listaDeReproducciones) {
    public Cancion(String titulo, String artista, String album, String anno) {
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.anno = anno;
//        this.listaDeReproducciones = listaDeReproducciones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    public ListaDeReproducciones getListaDeReproducciones() {
        return listaDeReproducciones;
    }

    public void setListaDeReproducciones(ListaDeReproducciones listaDeReproducciones) {
        this.listaDeReproducciones = listaDeReproducciones;
    }

    @Override
    public String toString() {
        return "Cancion{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", artista='" + artista + '\'' +
                ", album='" + album + '\'' +
                ", anno='" + anno + '\''
//                +
//                ", listaDeReproducciones=" + listaDeReproducciones +
//                '}'
                ;
    }
}
