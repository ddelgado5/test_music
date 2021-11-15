package quipux.co.api;

import quipux.co.entity.ListaDeReproducciones;
import quipux.co.pojo.ListaDeReproduccion;

import java.util.List;

public interface GetListReproduccion {
    List<ListaDeReproducciones> getAll();

    ListaDeReproducciones getNombreRepro(String nombre);
}
